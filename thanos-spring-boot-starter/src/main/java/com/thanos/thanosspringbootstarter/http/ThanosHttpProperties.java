package com.thanos.thanosspringbootstarter.http;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "thanos.http")
@Data
public class ThanosHttpProperties {

    private int connectTimeOut;
    private int socketTimeOut;
    private int connectionRequestTimeOut;

}
