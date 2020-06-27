package com.charles.finance.cli;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Config {

    public static String baseUrl() {
        return "http://localhost:8000/api";
    }

    public static RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        converterList.add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
    }
}
