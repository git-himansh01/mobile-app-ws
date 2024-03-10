package com.learning.mobileappws.exception;

public class UserServiceException extends RuntimeException{
    public UserServiceException(String message){
        //Our custom message is overriding the default message
        super(message);
    }
}
