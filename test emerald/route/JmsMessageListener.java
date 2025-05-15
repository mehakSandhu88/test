
package com.rbc.ipdEmerald.stub.route;

import

@Component
public class UmsMessageListener {

@Autowired
private MQRequestProcessor mqRequestProcessor;

@Autowired
private MQBessRequestProcessor mqBessRequestProcessor;

@JmsListener(destination = "QXGZO.RIT.IPD.BESS.REQUEST", containerFactory = "ipdApprovalContainerFactory") 
public void onMessage (Message message) {
    try {
            String correlationId = message.getJMSMessageID();
            byte[] messageBytes = message.getBody(byte[].class);
            String messageBody = new String(messageBytes, Charset.forName("UTF-8")); 
            mqRequestProcessor.process(messageBody, correlationId);
        } catch (Exception e) {
            System.err.println("Exception while processing message: " + e);
        }

    }
}

@JmsListener(destination = "QXGZO.RIT.IPD.BESS.REQUEST", containerFactory = "ipdApprovalContainerFactory") 
public void onBessMessage (Message message) {
    try {
            String correlationId = message.getJMSMessageID();
            String crn = message.getStringProperty(AppConstants.REQ_CRN);
            byte[] messageBytes = message.getBody(byte[].class);
            String bessmessageBody = new String(messageBytes, Charset.forName("UTF-8")); 
            mqBessRequestProcessor.process(bessmessageBody, correlationId, crn);
        
        } catch (Exception e) {
            System.err.println("Exception while processing message: " + e);
        }

    }
}
