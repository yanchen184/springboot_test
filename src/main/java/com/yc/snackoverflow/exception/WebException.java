package com.yc.snackoverflow.exception;

import lombok.Getter;

/**
 * @author meow
 */
@Getter
public class WebException extends RuntimeException{

    private final WebError webError;

    private final Object[] args;

    public WebException(final WebError webError) {
        this.webError = webError;
        this.args = null;
    }

    public WebException(final WebError webError, final Object... args) {
        super(webError.getErrorCode());
        this.webError = webError;
        this.args = args;
    }
}
