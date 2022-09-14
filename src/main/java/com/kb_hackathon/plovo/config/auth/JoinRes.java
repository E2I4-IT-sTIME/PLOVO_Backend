package com.kb_hackathon.plovo.config.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoinRes {
    private Long id;
    private String jwtToken;
}
