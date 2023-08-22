package com.academix_teacher.exceptions;

import com.sharedclasses.StandardResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserException {
    @ExceptionHandler(UserNotFoundException.class)
    public StandardResponse handleUserNotException(UserNotFoundException exc){
        return new StandardResponse("teacher not found", null,false);
    }






}
