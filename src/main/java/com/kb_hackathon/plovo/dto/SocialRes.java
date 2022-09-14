package com.kb_hackathon.plovo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import java.util.List;

@Builder
@ApiModel(value = "소셜 페이지 정보", description = "최근 플로깅 기록 리스트, 베스트 플로거 이름 리스트")
public class SocialRes {
    @ApiModelProperty(value = "최근 플로깅 기록 리스트")
    private List<String> recentPlog;
    @ApiModelProperty(value = "베스트 플로거 이름 리스트")
    private List<String> bestPlogger;
}
