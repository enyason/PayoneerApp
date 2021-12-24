package com.enyason.payoneerapp.core.api;

import lombok.Data;

@Data
public class PaymentMethodsResponse {
    private Links links;
    private String timestamp;
    private String operation;
    private String resultCode;
    private String resultInfo;
    private ReturnCode returnCode;
    private Status status;
    private Interaction interaction;
    private Identification identification;
    private Networks networks;
    private String operationType;
    private Style style;
    private Payment payment;
    private String integrationType;
}


