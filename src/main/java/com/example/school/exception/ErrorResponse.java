package com.example.school.exception;

import java.util.List;

/**
 * Created by Janak on 12-05-2020.
 */
public class ErrorResponse {
    String getMessage;
    List<String> getLocalizedMessage;

    public String getGetMessage() {
        return getMessage;
    }

    public void setGetMessage(String getMessage) {
        this.getMessage = getMessage;
    }

    public List<String> getGetLocalizedMessage() {
        return getLocalizedMessage;
    }

    public void setGetLocalizedMessage(List<String> getLocalizedMessage) {
        this.getLocalizedMessage = getLocalizedMessage;
    }

    public ErrorResponse(String getMessage, List<String> getLocalizedMessage) {
        this.getMessage = getMessage;
        this.getLocalizedMessage = getLocalizedMessage;
    }
}
