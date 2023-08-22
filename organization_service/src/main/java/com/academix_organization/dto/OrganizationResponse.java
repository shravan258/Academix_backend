package com.academix_organization.dto;

public class OrganizationResponse {
    private String message;

    private Object result;

    private Boolean success;

    public OrganizationResponse() {
    }

    public OrganizationResponse(String message, Object result,Boolean success) {
        this.message = message;
        this.result = result;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "OrganizationResponse{" +
                "message='" + message + '\'' +
                ", result=" + result +
                ", success=" + success +
                '}';
    }
}
