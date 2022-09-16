package com.kb_hackathon.plovo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "홈 화면 정보", description = "(플로보 무게 가벼운 순으로)플로깅 산 리스트, 최근 플로깅 기록 리를 가짐")
public class GetHomeRes {
    @ApiModelProperty(value = "(플로보 무게 가벼운 순으로)플로깅 산 리스트")
    private List<MountainRes> getMountainResList;
    @ApiModelProperty(value = "최근 플로깅 기록 리스트")
    private List<MountainRes> getRecentPlovos;
}
