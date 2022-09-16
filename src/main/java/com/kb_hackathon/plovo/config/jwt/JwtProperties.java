package com.kb_hackathon.plovo.config.jwt;

public interface JwtProperties {
    String SECRET = "plovo";
    int EXPIRATION_TIME =  60000*10*180; // 30분
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
