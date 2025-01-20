package com.adil.order_service.response;

import lombok.Data;

@Data
public class apiResponse {
    private String message;
    private Object data;

    public apiResponse(String message, Object data){
        this.data=data;
        this.message=message;
    }

}
