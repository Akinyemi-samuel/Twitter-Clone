package com.samuel.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus
@ControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiRequest.class)
    public ResponseEntity<Object> handleUserExists(ApiRequest apiRequest){
        ApiRequest apiRequest1 = new ApiRequest(apiRequest.getMessage(), apiRequest.getHttpStatus() );
        return new ResponseEntity<>(apiRequest1.getMessage(), apiRequest1.getHttpStatus());

    }
}
