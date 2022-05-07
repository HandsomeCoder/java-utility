package io.github.handsomecoder.exceptions;

public class InvalidHTTPRequestException extends RuntimeException {
    public InvalidHTTPRequestException(String message) {
        super(message);
    }
}
