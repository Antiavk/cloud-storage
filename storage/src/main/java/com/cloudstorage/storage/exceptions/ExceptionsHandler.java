package com.cloudstorage.storage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

@RestControllerAdvice
public class ExceptionsHandler {

    private Logger logger = Logger.getLogger(ExceptionsHandler.class.getName());

    @ExceptionHandler(BadCredentialException.class)
    public ResponseEntity badCredential(BadCredentialException exception) {
        this.logger.info(exception.getMessage());
        ResponseEntity response = new ResponseEntity("Incorrect login or password", HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(InputDataException.class)
    public ResponseEntity authError(InputDataException exception) {
        this.logger.info(exception.getMessage());
        ResponseEntity response = new ResponseEntity("Error input data", HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(AuthorizedException.class)
    public ResponseEntity authError(AuthorizedException exception) {
        this.logger.info(exception.getMessage());
        ResponseEntity response = new ResponseEntity("Unauthorized error", HttpStatus.UNAUTHORIZED);
        return response;
    }

    @ExceptionHandler(ServerError.class)
    public ResponseEntity serverError(ServerError exception) {
        this.logger.info(exception.getMessage());
        ResponseEntity response = new ResponseEntity("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
