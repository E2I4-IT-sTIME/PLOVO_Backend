package com.kb_hackathon.plovo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrentPlogRes {
    @ApiModelProperty(value = "산 이름")
    private String mountainName;
    @ApiModelProperty(value = "산 정보들")
    private List<PlogMountainInfoRes> plogMountainInfoRes;

}
