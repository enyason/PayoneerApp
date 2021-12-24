package com.enyason.payoneerapp.core.api;

import lombok.Data;

@Data
public class Identification {
    private String longId;
    private String shortId;
    private String transactionId;
}
