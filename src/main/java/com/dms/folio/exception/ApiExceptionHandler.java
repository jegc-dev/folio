package com.dms.folio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.time.LocalDateTime.now;

@ControllerAdvice
public class ApiExceptionHandler {

    HttpStatus badRequest = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(value = {APIRequestException.class})
    public ResponseEntity<Object> handleApiException(APIRequestException e) {
        ApiException apiException = new ApiException(e.getMessage(),
                badRequest,
                now());

        return new ResponseEntity<>(apiException, badRequest);

    }
}
