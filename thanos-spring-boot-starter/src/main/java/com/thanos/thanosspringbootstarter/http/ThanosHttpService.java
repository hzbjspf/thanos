package com.thanos.thanosspringbootstarter.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

@Slf4j
public class ThanosHttpService {

    private ThanosHttpProperties thanosHttpProperties;

    private CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(thanosHttpProperties.getConnectionRequestTimeOut())
            .setConnectTimeout(thanosHttpProperties.getConnectTimeOut())
            .setSocketTimeout(thanosHttpProperties.getSocketTimeOut())
            .build();

    public ThanosHttpService (ThanosHttpProperties thanosHttpProperties){
        this.thanosHttpProperties = thanosHttpProperties;
    }

    public HttpResponse sendPostRequest(String url){
        log.debug("http req url = {}",url);
        HttpPost httpPost = new HttpPost(url);
        return execute(httpPost);
    }

    public HttpResponse sendGetRequest(String url){
        log.debug("http req url = {}",url);
        HttpGet httpGet = new HttpGet(url);
        return execute(httpGet);
    }

    private HttpResponse execute (Object o){

        try{

            if (o instanceof HttpPost){

                HttpPost httpPost = (HttpPost) o;
                httpPost.setConfig(requestConfig);
                return httpClient.execute(httpPost);

            }else if (o instanceof HttpGet){

                HttpGet httpGet = (HttpGet) o;
                httpGet.setConfig(requestConfig);
                return httpClient.execute(httpGet);

            }else {

                throw new RuntimeException("不支持的http method");
            }

        }catch (java.io.IOException e){

            e.printStackTrace();

        }

        return null;
    }
}
