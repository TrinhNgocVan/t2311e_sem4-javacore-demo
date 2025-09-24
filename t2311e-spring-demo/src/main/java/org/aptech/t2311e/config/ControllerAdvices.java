package org.aptech.t2311e.config;

import org.aptech.t2311e.dto.ErrorResponse;
import org.aptech.t2311e.exception.BussinessException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<ErrorResponse> handleBussinessException(BussinessException be){
        ErrorResponse res = new ErrorResponse(be.getErrorCode(),be.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(200).body(res);
    }



}
