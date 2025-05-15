package com.rbc.ipdEmerald.stub.response;

import java.time.LocalDate;

@XmlRootElement(name = "payment_information")
@NoArgsConstructor
@Getter
public class PaymentInformationRes {

    @XmlElement(name = "unique_identifier")
    String unique_identifier;
    
    @XmlElement(name = "uetr")
    String UETR;
    
    @XmlElement(name = "end_to_end_identification")
    String end_to_end_id;
    
    @XmlElement(name = "approval_decision")
    String txn_approval_decision;
    
    @XmlElement(name = "payment_amount")
    String payment_amount;
    
    @XmlElement(name = "payment_amount_currency")
    String payment_amount_currency;
    
    @XmlElement(name = "final_amount")
    String finalAmt;
    
    @XmlElement(name = "final_amount_currency")
    String final_amount_currency;
    
    @XmlElement(name = "exchange_rate")
    String exchange_rate;
    
    @XmlElement(name = "contract_identification")
    String contract_identification;
    
    @XmlElement(name = "buy_sell_indicator")
    String buy_sell_indicator;
    
    @XmlElement(name = "buy_currency")
    String buy_currency;
    
    @XmlElement(name = "sell_currency")
    String sell_currency;
    
    @XmlElement(name = "currency_pair")
    String currency_pair;
    
    @XmlElement(name = "sell_amount")
    String sell_amount;
    
    @XmlElement(name = "originator_account_number")
    String originator_account_number;
    
    @XmlElement(name = "originator_account_number")
    String originator_currency_code;
    
    @XmlElement(name = "global_identification")
    String global_identification;
    
    @XmlElement(name = "transaction_reference")
    String transaction_reference;
    
    @XmlElement(name = "value_date")
    String value_date;
    
    @XmlElement(name = "status")
    String status;
    
    @XmlElement(name = "reject_reason")
    String reject_reason;
    
    public String getValue_date() {
        LocalDate today = LocalDate.now();
        String day = today.toString();
        return day;
    }
    
    public PaymentInformationRes(
            String unique_identifier,
            String end_to_end_id,
            String txn_approval_decision,
            String payment_amount,
            String payment_amount_currency,
            String originator_account_number,
            String originator_currency_code) {
        super();
        this.unique_identifier = unique_identifier;
        this.UETR = unique_identifier;
        this.end_to_end_id = end_to_end_id;
        this.txn_approval_decision = txn_approval_decision;
        this.payment_amount = payment_amount;
        this.payment_amount_currency = payment_amount_currency;
        this.finalAmt = payment_amount + 1;
        this.final_amount_currency = originator_currency_code;
        this.exchange_rate = "1.2458";
        this.contract_identification = "18726851";
        this.buy_sell_indicator = "SELL";
        this.buy_currency = originator_currency_code;
        this.sell_currency = payment_amount_currency;
        this.sell_amount = payment_amount;
        this.currency_pair = originator_currency_code + payment_amount_currency;
        this.originator_account_number = originator_account_number;
        this.global_identification = "400740";
        this.transaction_reference = "303774196/1";
        this.value_date = getValue_date();
        // this.value_date="2023-11-22";
        // this.status="ACCP";
        // this.reject_reason="no reason";
    }
}