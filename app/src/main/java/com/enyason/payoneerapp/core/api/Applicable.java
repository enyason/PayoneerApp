package com.enyason.payoneerapp.core.api;

import java.util.List;

import lombok.Data;

@Data
public class Applicable {
    public String code;
    public String label;
    public String method;
    public String grouping;
    public String registration;
    public String recurrence;
    public boolean redirect;
    public Links links;
    public boolean selected;
    public List<InputElement> inputElements;
    public String operationType;
    public ContractData contractData;
}
