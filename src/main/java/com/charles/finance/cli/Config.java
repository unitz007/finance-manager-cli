package com.charles.finance.cli;

public class Config {
    private static String baseUrl = "http://localhost:8000/api";

    public static String baseUrl() {
        return baseUrl;
    }
}
