package com.yc.snackoverflow.filter;

import com.yc.snackoverflow.wrapper.PkslowRequestWrapper;
import jakarta.servlet.ServletInputStream;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Slf4j
public class LoggingFilter extends CommonsRequestLoggingFilter {

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return true;
    }

    @Override
    protected void beforeRequest(HttpServletRequest req, String message) {
        log.info("Request Body: {}", message);
//        try {
//            PkslowRequestWrapper request = new PkslowRequestWrapper(req);
//            ServletInputStream servletInputStream = request.getInputStream();
//            String body = StreamUtils.copyToString(servletInputStream, Charset.defaultCharset());
//            log.info("Request Body(PkslowRequestWrapper): {}", body);
//        } catch (IOException e) {
//            logger.error("Failed to retrieve request payload: " + e.getMessage(), e);
//        }
    }

    @Override
    protected void afterRequest(HttpServletRequest res, String message) {
        log.info("Response Body: {}", message);
    }
}
