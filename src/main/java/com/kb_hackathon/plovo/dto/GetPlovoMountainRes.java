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
@ApiModel(value = "산 정보", description = "산 이름, 지도사진, 거리, 플로보 무게")
public class GetPlovoMountainRes {
    @ApiModelProperty(value = "유저 기록 id")
    private Long userRecord_id;
    @ApiModelProperty(value = "산 이름")
    private String mName;
    @ApiModelProperty(value = "지도 사진")
    private String mapImg;
    @ApiModelProperty(value = "거리", example = "0")
    private String distance;
    @ApiModelProperty(value = "플로보 무게", example = "0")
    private String plovoWeight;
}
