package com.enyason.payoneerapp.core.api;

import lombok.Data;

@Data
public class Payment {
    private String reference;
    private int amount;
    private String currency;
}
