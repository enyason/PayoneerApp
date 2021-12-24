package com.enyason.payoneerapp.core.api;

import java.util.List;

import lombok.Data;

@Data
public class Applicable {
    private String code;
    private String label;
    private String method;
    private String grouping;
    private String registration;
    private String recurrence;
    private boolean redirect;
    private Links links;
    private boolean selected;
    private List<InputElement> inputElements;
    private String operationType;
    private ContractData contractData;
}
