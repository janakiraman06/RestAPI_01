package com.example.school.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Janak on 16-05-2020.
 */
@Configuration
@EnableCaching
public class EhcacheConfig {
    @Bean
    public KeyGenerator studentKeyGenerator(){
        return (Object target, Method method, Object... params ) ->
                method.getName() + "_" + Arrays.toString(params);
    }
}
