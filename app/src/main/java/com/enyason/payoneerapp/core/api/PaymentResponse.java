package com.enyason.payoneerapp.core.api;

import lombok.Data;

@Data
public class PaymentResponse {
    public Links links;
    public String timestamp;
    public String operation;
    public String resultCode;
    public String resultInfo;
    public ReturnCode returnCode;
    public Status status;
    public Interaction interaction;
    public Identification identification;
    public Networks networks;
    public String operationType;
    public Style style;
    public Payment payment;
    public String integrationType;
}


