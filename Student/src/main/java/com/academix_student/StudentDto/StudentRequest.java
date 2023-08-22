package com.academix_student.StudentDto;

public class StudentRequest {

    private String student_name;

    private String student_email;

    private String student_password;

    private String branch;

    private Integer year;
    private Integer student_roll;

    private Integer student_organization;

    public StudentRequest() {
    }

    public StudentRequest(String student_name, String student_email, String student_password, String branch, Integer year, Integer student_roll, Integer student_organization) {
        this.student_name = student_name;
        this.student_email = student_email;
        this.student_password = student_password;
        this.branch = branch;
        this.year = year;
        this.student_roll = student_roll;
        this.student_organization = student_organization;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStudent_roll() {
        return student_roll;
    }

    public void setStudent_roll(Integer student_roll) {
        this.student_roll = student_roll;
    }

    public Integer getStudent_organization() {
        return student_organization;
    }

    public void setStudent_organization(Integer student_organization) {
        this.student_organization = student_organization;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }


    @Override
    public String toString() {
        return "StudentRequest{" +
                "student_name='" + student_name + '\'' +
                ", student_email='" + student_email + '\'' +
                ", student_password='" + student_password + '\'' +
                ", branch='" + branch + '\'' +
                ", year=" + year +
                ", student_roll=" + student_roll +
                ", student_organization=" + student_organization +
                '}';
    }
}
