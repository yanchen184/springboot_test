package com.yc.snackoverflow.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.lang.reflect.Field;

/**
 * @author meow
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {


    @EventListener(ApplicationReadyEvent.class)
    public void config() throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        Class<?> aClass = Class.forName("org.springframework.data.projection.ProxyProjectionFactory");
        Field field = aClass.getDeclaredField("CONVERSION_SERVICE");
        field.setAccessible(true);
        GenericConversionService service = (GenericConversionService) field.get(null);
//        service.addConverterFactory(new StringToEnumConverterFactory());
//        service.addConverterFactory(new IntegerEnumConverterFactory());
    }
}
