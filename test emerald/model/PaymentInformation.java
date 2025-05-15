package com.rbc.ipdEmerald.stub.model;

import ...;

@XmlRootElement(name = "payment_information")
@NoArgsConstructor
@Getter
public class PaymentInformation {
    @XmlElement(name = "unique_identifier")
    String unique_identifier;
    
    @XmlElement(name = "beneficiary_name")
    String beneficiary_name;
    
    @XmlElement(name = "beneficiary_account_number")
    String beneficiary_account_number;
    
    @XmlElement(name = "beneficiary_currency_code")
    String beneficiary_currency_code;
    
    @XmlElement(name = "beneficiary_iban")
    String beneficiary_iban;
    
    @XmlElement(name = "beneficiary_member_identification")
    String beneficiary_member_identification;
    
    @XmlElement(name = "payment_amount")
    String payment_amount;
    
    @XmlElement(name = "payment_amount_currency")
    String payment_amount_currency;
    
    @XmlElement(name = "exchange_rate")
    String exchange_rate;
    
    @XmlElement(name = "contract_identification")
    String contract_identification;
    
    @XmlElement(name = "end_to_end_id")
    String end_to_end_id;
    
    @XmlElement(name = "payment_status")
    String payment_status;
    
    @XmlElement(name = "rejection_reason")
    String rejection_reason;
    
    public PaymentInformation(
        String unique_identifier,
        String beneficiary_name,
        String beneficiary_account_number,
        String beneficiary_currency_code,
        String beneficiary_iban,
        String beneficiary_member_identification,
        String payment_amount,
        String payment_amount_currency,
        String exchange_rate,
        String contract_identification,
        String end_to_end_id,
        String payment_status,
        String rejection_reason) {
        
        super();
        this.unique_identifier = unique_identifier;
        this.beneficiary_name = beneficiary_name;
        this.beneficiary_account_number = beneficiary_account_number;
        this.beneficiary_currency_code = beneficiary_currency_code;
        this.beneficiary_iban = beneficiary_iban;
        this.beneficiary_member_identification = beneficiary_member_identification;
        this.payment_amount = payment_amount;
        this.payment_amount_currency = payment_amount_currency;
        this.exchange_rate = exchange_rate;
        this.contract_identification = contract_identification;
        this.end_to_end_id = end_to_end_id;
        this.payment_status = payment_status;
        this.rejection_reason = rejection_reason;
    }
}