package com.academix_organization.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organization_id;

    private String organization_name;

    private String organization_address;

    private Integer organization_contact;

    private String organization_email;

    private String organization_code;

    @ElementCollection
    List<Integer> organization_teachers_id = new ArrayList<>();




    public Organization() {
    }

    public Organization( String organization_name ,String organization_address, Integer organization_contact, String organization_email, String organization_code, List<Integer> organization_teachers_id) {
        this.organization_name = organization_name;
        this.organization_address = organization_address;
        this.organization_contact = organization_contact;
        this.organization_email = organization_email;
        this.organization_code = organization_code;
        this.organization_teachers_id = organization_teachers_id;
    }

    public Integer getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(Integer organization_id) {
        this.organization_id = organization_id;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getOrganization_address() {
        return organization_address;
    }

    public void setOrganization_address(String organization_address) {
        this.organization_address = organization_address;
    }

    public Integer getOrganization_contact() {
        return organization_contact;
    }

    public void setOrganization_contact(Integer organization_contact) {
        this.organization_contact = organization_contact;
    }

    public String getOrganization_email() {
        return organization_email;
    }

    public void setOrganization_email(String organization_email) {
        this.organization_email = organization_email;
    }

    public String getOrganization_code() {
        return organization_code;
    }

    public void setOrganization_code(String organization_code) {
        this.organization_code = organization_code;
    }

    public List<Integer> getOrganization_teachers_id() {
        return organization_teachers_id;
    }

    public void setOrganization_teachers_id(List<Integer> organization_teachers_id) {
        this.organization_teachers_id = organization_teachers_id;
    }

    public void addTeacher(Integer teacherId){
        organization_teachers_id.add(teacherId);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organization_id=" + organization_id +
                ", organization_name='" + organization_name + '\'' +
                ", organization_address='" + organization_address + '\'' +
                ", organization_contact=" + organization_contact +
                ", organization_email=" + organization_email +
                ", organization_code='" + organization_code + '\'' +
                ", organization_teachers_id=" + organization_teachers_id +
                '}';
    }
}
