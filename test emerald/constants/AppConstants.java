package com.rbc.ipdEmerald.stub.constants;

public class AppConstants {
    //MQ
    public static final String REQUEST_MQ_ROUTE = "jms:queue:{{ipd.input.queue}}?disableReplyTo=true";
    // Bess
    public static final String REQUEST_MQ_ROUTE_BESS = "jms:queue:{{ipd.bess.input.queue}}?disableReplyTo=true";

    public static final String JMS_CORRELATION_ID = "JMSCorrelationID";
     public static final String JMS_MSG_ID = "JMSMessageId"; 
    public static final String REQ_PID = "ReqPTId"; 
    public static final String REQ_TXN_ID = "ReqTxnid";
    public static final String REQ_CRN = "CRN"; 

}
