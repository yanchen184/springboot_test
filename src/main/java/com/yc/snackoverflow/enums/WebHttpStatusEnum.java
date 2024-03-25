package com.yc.snackoverflow.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

/**
 * @author meow
 */
@RequiredArgsConstructor
public enum WebHttpStatusEnum implements BaseEnum<Integer> {

    ERROR_NOT_FOUND(1001, "Network Authentication Required");

    @Getter
    private final Integer value;

    private final String reason;

}
