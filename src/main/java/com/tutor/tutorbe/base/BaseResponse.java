package com.tutor.tutorbe.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse implements Serializable {


    private static final long serialVersionUID = -8980855828244587537L;

    protected boolean succeeded;

    protected ResponseCode responseCode;

    protected String bizError;

    protected String responseMsg;


}
