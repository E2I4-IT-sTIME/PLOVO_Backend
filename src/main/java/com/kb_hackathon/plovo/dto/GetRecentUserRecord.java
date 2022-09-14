package com.kb_hackathon.plovo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "최근 플로깅한 정보", description = "거리, 플로깅 시간, 무게, 산 이름, 산 사진")
public class GetRecentUserRecord {
    @ApiModelProperty(value = "거리")
    private String distance;
    @ApiModelProperty(value = "플로깅 시간")
    private String plovoTime;
    @ApiModelProperty(value = "무게", example = "0")
    private Double weight;
    @ApiModelProperty(value = "산 이름")
    private String mName;
    @ApiModelProperty(value = "산 사진")
    private String mainImg;
}
