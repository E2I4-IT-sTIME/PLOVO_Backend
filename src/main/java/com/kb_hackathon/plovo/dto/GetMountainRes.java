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
@ApiModel(value = "산 정보", description = "산 이름, 이미지, 현재 플로보 무게")
public class GetMountainRes {
    @ApiModelProperty(value = "산 이름")
    private String mName;  // 산 이름
    @ApiModelProperty(value = "산 이미지")
    private String mImage;  // 산 이미지
    @ApiModelProperty(value = "현재 플로보 무게", example = "0")
    private String weight;  // 현재 플로보 무게
}
