package com.kb_hackathon.plovo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BestPloggerRes {
    @ApiModelProperty(value = "이름")
    private String username;
    @ApiModelProperty(value = "프로필 사진")
    private String profile_img;

}
