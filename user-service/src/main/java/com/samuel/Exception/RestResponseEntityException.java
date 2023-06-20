package com.samuel.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ResponseStatus
@RestControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
//        String errorMessage = errors.stream()
//                .map(ObjectError::getDefaultMessage)
//                .collect(Collectors.joining(", "));
//        return ResponseEntity.badRequest().body(errorMessage);
//    }

    @ExceptionHandler(ApiRequest.class)
    public ResponseEntity<Object> handleUserExists(ApiRequest apiRequest){
        ApiRequest apiRequest1 = new ApiRequest(apiRequest.getMessage(), apiRequest.getHttpStatus() );
        return new ResponseEntity<>(apiRequest1.getMessage(), apiRequest1.getHttpStatus());
    }
}
