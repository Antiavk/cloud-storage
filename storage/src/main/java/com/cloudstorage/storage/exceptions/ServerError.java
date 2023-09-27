package com.cloudstorage.storage.exceptions;

public class ServerError extends RuntimeException {
    public ServerError(String message) {
        super(message);
    }
}
