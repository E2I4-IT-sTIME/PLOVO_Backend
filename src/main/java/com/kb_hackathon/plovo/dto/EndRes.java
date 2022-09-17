package com.kb_hackathon.plovo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class EndRes {
    @ApiModelProperty(value = "산 이름")
    private String m_name;
    @ApiModelProperty(value = "플로깅 날짜")
    private String date;
    @ApiModelProperty(value = "플로깅 거리", example = "0")
    private String distance;
    @ApiModelProperty(value = "플로깅 시간")
    private String time;
    @ApiModelProperty(value = "플로깅한 무게", example = "0")
    private String weight;
    @ApiModelProperty(value = "6개월치 무게 수치")
    private List<MonthAndWeightRes> monthAndWeightRes; // 6개월치 무게 수치
}
