package com.dms.folio.exception;

public class DocumentaryTypeNotFoundException extends RuntimeException {
    public DocumentaryTypeNotFoundException(String message){
        super(message);
    }
}
