package com.kb_hackathon.plovo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;

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

    @ApiModelProperty(value = "산 거리")
    @Nullable
    @Column(nullable = true)
    private String distance; // 산 거리

    @ApiModelProperty(value = "플로깅 시간")
    @Nullable
    @Column(nullable = true)
    private String time;

//    public GetMountainRes(String mName, String mImage, String weight, @Nullable String distance, @Nullable String time) {
//        this.mName = mName;
//        this.mImage = mImage;
//        this.weight = weight;
//        this.distance = distance;
//        this.time = time;
//    }
}
