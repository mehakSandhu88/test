
package com.rbc.ipdEmerald.stub.processor;

import ...;

@Component
@Slf4j
public class MQRequestProcessor {

    @Autowired
    private MQService mqService;

    public void process(String inpMsg, String correlationId) throws Exception {
        // String correlationId = exchange.getIn().getHeader(AppConstants.JMS_CORRELATION_ID,
        // String.class).substring(3);
        // String correlationId = exchange.getIn().getHeader(AppConstants.JMS_MSG_ID, String.class);
        // log.info("- JMS_MSG_ID=" + exchange.getIn().getHeader(AppConstants.JMS_MSG_ID, String.class));
        // log.info("- JMS_CORRELATION_ID=" + exchange.getIn().getHeader(AppConstants.JMS_CORRELATION_ID,
        // String.class));
        // log.info("- ReqPID=" + exchange.getIn().getHeader(AppConstants.REQ_PID, String.class));
        // log.info("- ReqTxnId=" + exchange.getIn().getHeader(AppConstants.REQ_TXN_ID, String.class));

        String receivedMsg = inpMsg;
        log.debug(receivedMsg);
        StringReader sr = new StringReader(receivedMsg);
        
        JAXBContext jaxbContext = JAXBContext.newInstance(ApprovalRequest.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ApprovalRequest request = (ApprovalRequest) unmarshaller.unmarshal(sr);
        System.out.println("request: " + request);
        
        ApprovalResponse approvalResponse = new ApprovalResponse();
        approvalResponse.setCorrelation_id(request.getCorrelation_id());
        approvalResponse.setClient_id(request.getClient_id());
        approvalResponse.setSource_channel(request.getSource_channel());
        String tempcar = (request.getRequest_date()) + "[UTC]";
        approvalResponse.setCreDtTm(tempcar);
        
        String approvalDecision;
        // File authorisation decision either "Approved", "Declined", "Expired", "None", "Partial" and can be
        if (request.getClient_id().contentEquals("234001370")) {
            approvalDecision = "Declined";
        } else if (request.getClient_id().contentEquals("234001420")) {
            approvalDecision = "Expired";
        } else if(request.getClient_id().contentEquals("386903959")) {
            approvalDecision = "None";
        } else if (request.getClient_id().contentEquals("386903819")) {
            approvalDecision = "Partial";
        } else {
            if (request.getAction_required().contentEquals("FX")) {
                approvalDecision = "None";
            } else {
                approvalDecision = "Approved";
            }
        }
        
        approvalResponse.setApproval_decision(approvalDecision);
        // FX response when action_required is approval- Fx is Not Applicable
        if (!request.getAction_required().contentEquals("APPROVAL")) {
            approvalResponse.setFX("Provided");
        } else {
            approvalResponse.setFX("NotApplicable");
        }
        
        for (File fileObj : request.getFile()) {
            ResponseFile responsefile = new ResponseFile(
                fileObj.getFile_name(), fileObj.getFile_type(), fileObj.getFile_reference_number());
            approvalResponse.getListFile().add(responsefile);
        }
        
        if (request.getAction_required().contentEquals("APPROVAL")) {
            for (Batch batchObj : request.getBatch()) {
                for (PaymentInformation paymentObj : batchObj.getPayment_information()) {
                    PaymentInformationRes infoObj = new PaymentInformationRes(
                        paymentObj.getUnique_identifier(),
                        paymentObj.getEnd_to_end_Id(),
                        approvalDecision,
                        paymentObj.getPayment_amount(),
                        paymentObj.getPayment_amount_currency(),
                        batchObj.getOriginator_account_number(),
                        batchObj.getOriginator_currency_code());
                    approvalResponse.getListPaymentInformation().add(infoObj);
                }
            }
            
            JAXBContext context = JAXBContext.newInstance(ApprovalResponse.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(approvalResponse, writer);
            
            String xml = writer.toString();
            mqService.sendMessage(xml, correlationId);
        }
    }
}