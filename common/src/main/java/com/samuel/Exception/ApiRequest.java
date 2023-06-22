package com.samuel.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class ApiRequest extends RuntimeException{
    private String message;

    private HttpStatus httpStatus;

    public ApiRequest(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
