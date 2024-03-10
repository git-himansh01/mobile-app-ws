package com.learning.mobileappws.exception;

import com.learning.mobileappws.ui.model.response.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception exp, WebRequest request){
        String errorMessageDescription = exp.getLocalizedMessage();
        //   if(errorMessageDescription == null) errorMessageDescription= exp.getMessage();
        // ErrorMessage errorMessage= new ErrorMessage(new Date(), exp.getLocalizedMessage());
        if(errorMessageDescription == null) errorMessageDescription = exp.toString();
        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorMessageDescription);
     //   return new ResponseEntity<>(exp, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value={UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException exp, WebRequest request){
        String errorMessageDescription = exp.getLocalizedMessage();
        //   if(errorMessageDescription == null) errorMessageDescription= exp.getMessage();
        // ErrorMessage errorMessage= new ErrorMessage(new Date(), exp.getLocalizedMessage());
        if(errorMessageDescription == null) errorMessageDescription = exp.toString();
        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorMessageDescription);
        //   return new ResponseEntity<>(exp, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
