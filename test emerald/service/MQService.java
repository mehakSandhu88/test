package com.rbc.ipdEmerald.stub.service;

import ...

@Service
@EnableJms
@RequiredArgsConstructor
@Slf4j
public class MQService {
    @Autowired
    JmsTemplate jmsTemplate;
    
    @Value("${MQZG.IPD.BBPO.REPLY}")
    private String ipdOutputQueue;
    
    @Value("${MQZG.PO.IPD.REPLY.TACM}")
    private String ipdBessOutputQueue;
    
    @Value("${MQZG.PO.IPD.REPLY.CACM}")
    private String ipdBessCMPOutputQueue;
    
    public boolean sendMessage(String message, String correlationID) throws JMSException {
        boolean sent = true;
        MQQueue outQueue = new MQQueue(ipdOutputQueue);
        try {
            log.info("{} - correlationID for the exchange:", correlationID);
            log.info("Sending to response queue: \n {}", message);
            jmsTemplate.convertAndSend(outQueue, message, Message m -> {
                // m.setJMSCorrelationIDAsBytes(DatatypeConverter.parseHexBinary(correlationID));
                // m.setJMSCorrelationIDAsBytes(correlationID.getBytes());
                m.setJMSCorrelationID(correlationID);
                // m.setJMSMessageID(correlationID);
                return m;
            });
            log.info("Sent to IPD response queue.");
        } catch (Exception e) {
            log.error("Exception in posting message to IPD MQ:");
            e.printStackTrace();
            throw e;
        }
        return sent;
    }
    
    public boolean sendBessMessage(String strPID, String strCRN, String strIRN, String payload, String correlationID) 
        throws JMSException {
        boolean sent = true;
        MQQueue outBessQueue = new MQQueue(ipdBessOutputQueue);
        try {
            log.info("{} - correlationID for the exchange:", correlationID);
            log.info("Sending to BESS response queue: \n {}...", payload);
            jmsTemplate.convertAndSend(outBessQueue, payload, Message m -> {
                // m.setJMSCorrelationIDAsBytes(DatatypeConverter.parseHexBinary(correlationID));
                // m.setJMSCorrelationIDAsBytes(correlationID.getBytes());
                m.setStringProperty(MQConstants.JMS_IBM_MQMD_FORMAT, "MQRFH2");
                m.setJMSCorrelationID(correlationID);
                m.setStringProperty("PID", strPID);
                m.setStringProperty("MSGTP", "TAK     ");
                m.setStringProperty("SRC", "        ");
                m.setStringProperty("HSZ", "HSZ     ");
                m.setStringProperty("CRN", strCRN);
                m.setStringProperty("IRN", strIRN);
                m.setStringProperty("ID1", "                                  ");
                m.setStringProperty("ID2", "000                               ");
                m.setStringProperty("ID3", "                                  ");
                m.setStringProperty("DAT1", "                                  ");
                m.setStringProperty("DAT2", "                                  ");
                m.setStringProperty("DAT3", "                                  ");
                m.setStringProperty(
                    "FILLER", 
                    "                                  ");
                // m.setJMSMessageID(correlationID);
                return m;
            });
            log.info("Sent to BESS response queue.");
        } catch (Exception e) {
            log.error("Exception in posting message to BESS MQ:");
            e.printStackTrace();
            throw e;
        }
        return sent;
    }
    
    public boolean sendBessCMPMessage(String strPID, String strCRN, String strIRN, String payload, String correlationID) 
        throws JMSException {
        boolean sent = true;
        MQQueue outBessCMPQueue = new MQQueue(ipdBessCMPOutputQueue);
        try {
            log.info("{} - correlationID for the exchange:", correlationID);
            log.info("Sending to BESS response queue: \n {}...", payload);
            jmsTemplate.convertAndSend(outBessCMPQueue, payload, Message m -> {
                // m.setJMSCorrelationIDAsBytes(DatatypeConverter.parseHexBinary(correlationID));
                // m.setJMSCorrelationIDAsBytes(correlationID.getBytes());
                m.setStringProperty(MQConstants.JMS_IBM_MQMD_FORMAT, "MQRFH2");
                m.setJMSCorrelationID(correlationID);
                m.setStringProperty("PID", strPID);
                m.setStringProperty("MSGTP", "CMP     ");
                m.setStringProperty("SRC", "        ");
                m.setStringProperty("HSZ", "HSZ     ");
                m.setStringProperty("CRN", strCRN);
                m.setStringProperty("IRN", strIRN);
                m.setStringProperty("ID1", "                                  ");
                m.setStringProperty("ID2", "001                               ");
                m.setStringProperty("ID3", "                                  ");
                m.setStringProperty("DAT1", "                                  ");
                m.setStringProperty("DAT2", "                                  ");
                m.setStringProperty("DAT3", "                                  ");
                m.setStringProperty(
                    "FILLER", 
                    "                                  ");
                // m.setJMSMessageID(correlationID);
                return m;
            });
            log.info("Sent to BESS CMP response queue.");
        } catch (Exception e) {
            log.error("Exception in posting message to BESS CMP MQ:");
            e.printStackTrace();
            throw e;
        }
        return sent;
    }
}