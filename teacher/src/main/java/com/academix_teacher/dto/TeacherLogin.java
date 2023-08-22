package com.academix_teacher.dto;

public class TeacherLogin {

    private String email;
    private String password;

    private String orgcode;

    public TeacherLogin() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    @Override
    public String toString() {
        return "TeacherLogin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", orgcode='" + orgcode + '\'' +
                '}';
    }
}
