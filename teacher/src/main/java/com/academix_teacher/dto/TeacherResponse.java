package com.academix_teacher.dto;

public class TeacherResponse {
    private String message;

    private Object result;

    private Boolean success;

    public TeacherResponse() {
    }

    public TeacherResponse(String message, Object result, Boolean success) {
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
        return "TeacherResponse{" +
                "message='" + message + '\'' +
                ", result=" + result +
                ", success=" + success +
                '}';
    }
}
