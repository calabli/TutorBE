package com.tutor.tutorbe.base;

import lombok.Data;
import lombok.ToString;



@Data
@ToString(callSuper = true)
public class FacadeResponse<T> extends BaseResponse {


    private static final long serialVersionUID = 6830151364221945245L;
    /**
     * Response object
     */
    protected T value;

    public void fillWithSuccess(){
        setSucceeded(true);
        setResponseCode(ResponseCode.SUCCESS);
    }

    public void fillWithSuccess(String msg){
        setSucceeded(true);
        setResponseCode(ResponseCode.SUCCESS);
        setResponseMsg(msg);
    }

    public void fillWithSuccessAssignCode(ResponseCode responseCode, String msg){
        setSucceeded(true);
        setResponseCode(responseCode);
        setResponseMsg(msg);
    }

    public void fillWithUnSuccess(ResponseCode responseCode){
        setSucceeded(false);
        setResponseCode(responseCode);
    }

    public void fillWithUnSuccess(ResponseCode responseCode, String msg){
        setSucceeded(false);
        setResponseCode(responseCode);
        setResponseMsg(msg);
    }
}

