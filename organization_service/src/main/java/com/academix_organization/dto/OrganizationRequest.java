package com.academix_organization.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class OrganizationRequest {

    @NotBlank(message = "Name is required")
    private String organization_name;

    @Size(min = 6, max = 150, message = "length must be between 6 and 150 characters")
    private String organization_address;

    private Integer organization_contact;

    @Email(message = "Email should be valid")
    private String organization_email;

    public OrganizationRequest() {
    }

    public OrganizationRequest(String organization_name, String organization_address, Integer organization_contact, String organization_email) {
        this.organization_name = organization_name;
        this.organization_address = organization_address;
        this.organization_contact = organization_contact;
        this.organization_email = organization_email;
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

    @Override
    public String toString() {
        return "OrganizationRequest{" +
                "organization_name='" + organization_name + '\'' +
                ", organization_address='" + organization_address + '\'' +
                ", organization_contact=" + organization_contact +
                ", organization_email=" + organization_email +
                '}';
    }
}
