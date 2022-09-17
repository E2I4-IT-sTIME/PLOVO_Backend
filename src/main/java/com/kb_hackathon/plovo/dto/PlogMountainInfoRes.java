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
public class PlogMountainInfoRes {
    private String mName;  // 산 이름
    private String mImage;  // 산 이미지
    private String distance; // 산 거리
    private String time; // 플로깅 시간
    private String weight; // 플로깅 무게
    private String userProfile; // 유저 프로필 사진
}
