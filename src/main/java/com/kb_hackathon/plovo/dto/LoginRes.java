package com.kb_hackathon.plovo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class LoginRes {
    private String jwtToken;
    private Boolean isExist;
}
