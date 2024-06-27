package com.yc.snackoverflow.config;

import com.yc.snackoverflow.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * @author meow
 */
@Configuration
public class LoggingConfig {
//    @Bean
//    public CommonsRequestLoggingFilter loggingFilter() {
//        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
//        filter.setIncludeHeaders(true);
//        filter.setIncludeClientInfo(true);
//        filter.setIncludePayload(true);
//        filter.setIncludeQueryString(true);
//        filter.setAfterMessagePrefix("CommonsRequestLoggingFilter Request: ");
//
//        return filter;
//    }


    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilterRegistration() {
        FilterRegistrationBean<LoggingFilter> registration = new FilterRegistrationBean<>();
        LoggingFilter loggingFilter = new LoggingFilter();
//        loggingFilter.setIncludePayload(true);
//        loggingFilter.setIncludeQueryString(true);
        registration.setFilter(loggingFilter);
        registration.addUrlPatterns("/*");
        registration.setName("loggingFilter");
        return registration;
    }
}
