package org.aptech.t2311e.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public  class BussinessException extends  Exception {
    private final String  errorCode;
    private final HttpStatus status;

    public BussinessException(String message, String errorCode, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}
