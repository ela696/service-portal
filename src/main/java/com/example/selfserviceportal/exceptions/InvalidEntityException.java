package com.example.selfserviceportal.exceptions;


import com.example.selfserviceportal.exceptions.abstracts.AbstractEntityException;
import com.example.selfserviceportal.handlers.ErrorCodes;

import java.util.List;

public class InvalidEntityException extends AbstractEntityException {

    public InvalidEntityException(String message , ErrorCodes errorCodes , List<String> errors){
        super(message, errorCodes, errors);
    }

    public InvalidEntityException(String message , ErrorCodes errorCodes){
        super(message,errorCodes);
    }
}
