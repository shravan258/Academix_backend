package com.sharedclasses;


public class AuthenticationResponse {
    private String token;

    private Integer Id;

    private Role role;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token, Integer Id, Role role) {
        this.token = token;
        this.Id = Id;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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
                ", Id=" + Id +
                ", role=" + role +
                '}';
    }
}
