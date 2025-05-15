package com.rbc.ipdEmerald.stub.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement(name = "file")
@NoArgsConstructor
@Getter
public class Batch {

    @XmlElement(name = "payment_information_identification")
    String batch_Id;

    @XmlElement(name = "type_of_payment")
    String type_of_payment;

    @XmlElement(name = "number_of_rejected_transactions")
    String no_of_transactions_rejected;

    @XmlElement(name = "number_of_valid_transactions")
    String number_of_valid_transactions;

    @XmlElement(name = "originator_account_number")
    String originator_account_number;

    @XmlElement(name = "originator_currency_code")
    String originator_currency_code;

    @XmlElement(name = "requested_execution_date")
    String requested_execution_date;

    @XmlElement(name = "payment_information")
    List<PaymentInformation> payment_information;

    public Batch(
        String batch_Id,
        String type_of_payment,
        String no_of_transactions_rejected,
        String number_of_valid_transactions,
        String originator_account_number,
        String originator_currency_code,
        String requested_execution_date,
        List<PaymentInformation> payment_information
    ) {
        super();
        this.batch_Id = batch_Id;
        this.type_of_payment = type_of_payment;
        this.no_of_transactions_rejected = no_of_transactions_rejected;
        this.number_of_valid_transactions = number_of_valid_transactions;
        this.originator_account_number = originator_account_number;
        this.originator_currency_code = originator_currency_code;
        this.requested_execution_date = requested_execution_date;
        this.payment_information = payment_information;
    }
}
