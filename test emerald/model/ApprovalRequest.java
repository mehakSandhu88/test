package com.rbc.ipdEmerald.stub.model;

import ...;

@XmlRootElement(name = "approval_required")
@XmlArgsConstructor
@Setter
public class ApprovalRequest {
    @XmlElement(name = "correlation_id")
    String correlation_id;
    
    @XmlElement(name = "creation_datetime")
    public String request_date;
    
    @XmlElement(name = "source_channel")
    String source_channel;
    
    @XmlElement(name = "client_id")
    String client_id;
    
    @XmlElement(name = "eid")
    String eid;
    
    @XmlElement(name = "file")
    List<File> file;
    
    @XmlElement(name = "action_required")
    String action_required;
    
    @XmlElement(name = "authorisation")
    String authorisation;
    
    @XmlElement(name = "number_of_transactions")
    String number_of_transactions;
    
    @XmlElement(name = "control_sum")
    String control_sum;
    
    @XmlElement(name = "total_accounts")
    String total_accounts;
    
    @XmlElement(name = "total_batches")
    String total_batches;
    
    @XmlElement(name = "batch")
    List<Batch> batch;
    
    public ApprovalRequest(
        String correlation_id,
        String request_date,
        String source_channel,
        String client_id,
        String eid,
        List file,
        String action_required,
        String authorisation,
        String number_of_transactions,
        String control_sum,
        String total_accounts,
        String total_batches,
        List batch) {
        
        super();
        this.correlation_id = correlation_id;
        this.request_date = request_date;
        this.source_channel = source_channel;
        this.client_id = client_id;
        this.eid = eid;
        this.file = file;
        this.action_required = action_required;
        this.authorisation = authorisation;
        this.number_of_transactions = number_of_transactions;
        this.control_sum = control_sum;
        this.total_accounts = total_accounts;
        this.total_batches = total_batches;
        this.batch = batch;
    }
}