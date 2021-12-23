package com.enyason.payoneerapp.core.api;

import lombok.Data;

@Data
public class Payment {
    public String reference;
    public int amount;
    public String currency;
}
