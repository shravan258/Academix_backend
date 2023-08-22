package com.sharedclasses;


public class AuthenticationResponse {
    private String token;

    private Integer teacherId;

    private Role role;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token, Integer teacherId, Role role) {
        this.token = token;
        this.teacherId = teacherId;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "token='" + token + '\'' +
                ", teacherId=" + teacherId +
                ", role=" + role +
                '}';
    }
}
