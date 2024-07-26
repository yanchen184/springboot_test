package com.yc.snackoverflow.advice;

import com.yc.snackoverflow.exception.WebError;
import com.yc.snackoverflow.exception.WebErrorEnum;
import com.yc.snackoverflow.exception.WebException;
import com.yc.snackoverflow.handler.ResultData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {

    private final MessageSource messageSource;

    @ExceptionHandler(WebException.class)
    public ResultData<Object> handleWebException(final WebException e) {
        final WebError webError = e.getWebError();
        log.error("[WebException]: {} ", webError.getErrorLog());
//        final String resMessage = messageSource.getMessage(webError.getErrorCode(), e.getArgs(), LocaleContextHolder.getLocale());
        return ResultData.fail(webError.getErrorCode(), webError.getErrorLog());
    }

}
