package com.yc.snackoverflow.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static com.yc.snackoverflow.enums.WebHttpStatusEnum.ERROR_EXISTS;
import static com.yc.snackoverflow.enums.WebHttpStatusEnum.ERROR_NOT_FOUND;

/**
 * @author meow
 */
@Getter
@RequiredArgsConstructor
public enum WebErrorEnum implements WebError {

    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERR0001", "Custom internal Error. " ),
    MISSING_TOKEN(HttpStatus.UNAUTHORIZED.value(), "ERR0002", "Missing token. "),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED.value(), "ERR0003", "Invalid token. "),
    INVALID_ARG(HttpStatus.BAD_REQUEST.value(), "ERR0004", "Invalid arg: {}. "),
    UPSERT_FAILED(HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERR0005", "Upsert failed. "),
    BOOKING_NOT_FOUND(ERROR_NOT_FOUND, "ERR0006", "Booking not found. Booking id : [%s]"),
    MEMBER_NOT_FOUND(ERROR_NOT_FOUND, "ERR0007", "Member not found. "),
    MEMBER_EXISTS(ERROR_EXISTS, "ERR0008", "Member exists. "),
    PRODUCT_NOT_FOUND(ERROR_NOT_FOUND, "ERR0009", "Product not found. "),
    PRODUCT_EXISTS(ERROR_EXISTS, "ERR0010", "Product exists. "),
    PRODUCT_CLASS_NOT_FOUND(ERROR_NOT_FOUND, "ERR0011", "Product class not found. "),
    ;

    private final int statusCode;
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
