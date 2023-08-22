package com.academix_organization.Exceptions;

public class DuplicateOrganizationException extends Exception{
    public DuplicateOrganizationException() {
        super();
    }

    public DuplicateOrganizationException(String message) {
        super(message);
    }

    public DuplicateOrganizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
