package com.yc.snackoverflow.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author meow
 */
@Getter
@RequiredArgsConstructor
public enum WebErrorEnum implements WebError {

    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "ERR0001", "Custom internal Error. "),
    MISSING_TOKEN(HttpStatus.UNAUTHORIZED, "ERR0002", "Missing token. "),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "ERR0003", "Invalid token. "),
    INVALID_ARG(HttpStatus.BAD_REQUEST, "ERR0004", "Invalid arg: {}. "),
    UPSERT_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "ERR0005", "Upsert failed. "),
    ;

    private final HttpStatus statusCode;
    private final String errorCode;
    private final String errorLog;


    @Override
    public WebException exception() {
        return new WebException(this);
    }

    @Override
    public WebException exception(Object... args) {
        return new WebException(this, args);
    }
}
