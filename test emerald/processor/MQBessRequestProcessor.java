package com.rbc.ipd.emerald.stub.processor;

import ...; // Import statements are partially visible in the image

@Component
@Slf4j
public class MQBessRequestProcessor {

    @Autowired
    private MQService mqService;

    public void process(String inpBessMsg, String correlationId, String crn) throws Exception {
        // String correlationId = exchange.getIn().getHeader(AppConstants.JMS_CORRELATION_ID, String.class);
        // String.class).toString();
        //String correlationId = exchange.getIn().getHeader(AppConstants.JMS_MSG_ID, String.class);
        //log.info("- JMS_MSG_ID=" + exchange.getIn().getHeader(AppConstants.JMS_MSG_ID, String.class));
        //log.info("- JMS_CORRELATION_ID=" + exchange.getIn().getHeader(AppConstants.JMS_CORRELATION_ID, String.class));
        //log.info("- REQ_CRN=" + exchange.getIn().getHeader(AppConstants.REQ_CRN, String.class));

        String receivedMsg = inpBessMsg;
        
        log.info("received MT 103: " + receivedMsg);
        
        // random Alpha for the PID
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 15;
        Random random = new Random();
        
        String generatedString = random.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
            
        log.info("-concatenated generatedString=" + generatedString);
        
        // Date format for ICN and PID
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuuMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        log.info("-concatenated now=" + dtf.format(now));
        
        // PID CRN and ICN generation
        String strPID = dtf.format(now) + crn + generatedString.toUpperCase();
        log.info("-concatenated PID=" + strPID);
        
        // String strCRN=exchange.getIn().getHeader(AppConstants.REQ_CRN, String.class);
        String strCRN = crn;
        while (strCRN.length() < 11) {
            strCRN = strCRN.concat("WS" + " ");
        }
        log.info("-concatenated CRN=" + strCRN);
        
        String strICN = "CA" + dtf.format(now) + "O";
        String cmpICN = dtf.format(now) + "O";
        log.info("-concatenated ICN=" + strICN);
        
        // Empty raw data for the Teck ACK
        String payload = "";
        
        // Post the teck ack to the QXGZ0.PD.IPD.REPLY.TACK queue
        mqService.sendBessMessage(strPID, strCRN, strICN, payload, correlationId);
        // mqService.sendBessMessage(exchange.getIn().getHeader(AppConstants.REQ_CRN, String.class),correlationId);
        
        TimeUnit.SECONDS.sleep(1);
        int MtlO3length = generatedString.length();
        // String E2EID=generatedString.substring(145,158);
        
        // log.info("-concatenated MtlO3length=" + MtlO3length);
        // log.info("-concatenated E2EID=" + E2EID);
        
        // complete ack payload
        String CmpPayload = 
            "   MSJPPPPPPPPPPPPPP M  24020810101Z  00000        0000        24020810101??       INCON CORPORATION            SIRI 10510558    II";
            
        CmpPayload = CmpPayload.replace("PPPPPPPPPPPPPPP", cmpICN);
        CmpPayload = CmpPayload.replace("CCCCCCCCCCC", strCRN);
        // 145 158
        
        mqService.sendBessCMPMessage(strPID, strCRN, strICN, CmpPayload, correlationId);
    }
}