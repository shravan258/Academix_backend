package com.academix_organization.Exceptions;


import com.academix_organization.entity.ErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllOrganizationExceptions {
    @ExceptionHandler(DuplicateOrganizationException.class)
    public ResponseEntity<ErrorEntity> handleUserNotException(DuplicateOrganizationException exc){
        ErrorEntity errorRes = new ErrorEntity();
        errorRes.setError("Duplicate Organization found");
        errorRes.setMessage("Please provide valid credentials");
        return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);

    }
}
