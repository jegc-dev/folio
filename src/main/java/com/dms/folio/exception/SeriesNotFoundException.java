package com.dms.folio.exception;

public class SeriesNotFoundException extends RuntimeException {
    public SeriesNotFoundException(String message){
        super(message);
    }
}
