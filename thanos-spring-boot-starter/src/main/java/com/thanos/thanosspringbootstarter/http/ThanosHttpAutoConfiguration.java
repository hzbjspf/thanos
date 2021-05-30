package com.thanos.thanosspringbootstarter.http;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = ThanosHttpProperties.class)
@Configuration
public class ThanosHttpAutoConfiguration {

    @Bean
    public ThanosHttpService thanosHttpService(ThanosHttpProperties thanosHttpProperties){
        return new ThanosHttpService(thanosHttpProperties);
    }

}
