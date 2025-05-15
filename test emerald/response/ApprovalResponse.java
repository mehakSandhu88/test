package com.rbc.ipdEmerald.stub.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "approval_details")
@NoArgsConstructor
@Setter
public class ApprovalResponse implements Serializable {

    @XmlElement(name = "correlation_id")
    String correlation_id;

    @XmlElement(name = "creation_datetime")
    String CreDTm;

    @XmlElement(name = "source_channel")
    String source_channel;

    @XmlElement(name = "client_id")
    String client_id;

    @XmlElement(name = "file")
    List<ResponseFile> responseFile;

    @XmlElement(name = "approval_decision")
    String approval_decision;

    @XmlElement(name = "fx")
    String FX;

    @XmlElement(name = "payment_information")
    List<PaymentInformationRes> paymentinformation;

    public ApprovalResponse(
        String correlation_id,
        String CreDTm,
        String source_channel,
        String client_id,
        List<ResponseFile> file,
        String approval_decision,
        String FX,
        List<PaymentInformationRes> paymentinformation
    ) {
        super();
        this.correlation_id = correlation_id;
        this.CreDTm = CreDTm + "[UTC]";
        this.source_channel = source_channel;
        this.client_id = client_id;
        this.responseFile = file;
        this.approval_decision = approval_decision;
        this.FX = FX;
        this.paymentinformation = paymentinformation;
    }

    public List<ResponseFile> getListFile() {
        if (this.responseFile == null) {
            this.responseFile = new ArrayList<>();
        }
        return responseFile;
    }

    public List<PaymentInformationRes> getListPaymentInformation() {
        if (this.paymentinformation == null) {
            this.paymentinformation = new ArrayList<>();
        }
        return paymentinformation;
    }
}
