package com.pertsol.mainservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
*  Common response wrapper to send status, message, code, and data in API responses
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String status;
    private String message;
    private int code;
    private T data;

    public ApiResponse(String status, String message, int code, T data) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    // Getters & Setters
    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

}
