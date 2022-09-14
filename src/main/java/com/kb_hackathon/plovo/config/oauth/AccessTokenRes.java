package com.kb_hackathon.plovo.config.oauth;

import lombok.Data;

@Data
public class AccessTokenRes {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private int refresh_token_expires_in;
}
