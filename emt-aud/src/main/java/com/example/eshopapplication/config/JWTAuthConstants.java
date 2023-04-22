package com.example.eshopapplication.config;

public class JWTAuthConstants {
    public static final long EXPIRATION_DATE = 864_000_000; // 10 days
    public static final String SECRET = "s3cr3tt0k3n";
    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
