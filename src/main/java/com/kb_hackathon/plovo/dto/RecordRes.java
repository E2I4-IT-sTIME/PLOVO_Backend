package com.kb_hackathon.plovo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "기록 페이지 정보", description = "사용자 이름, 프로필 사진, 플로깅 시간 리스트, 플로깅 무게 리스트")
public class RecordRes {
    @ApiModelProperty(value = "사용자 이름")
    private String username;
    @ApiModelProperty(value = "사용자 프로필 사진")
    private String profileImg;
    @ApiModelProperty(value = "플로깅 일자별 시간, 무게 리스트")
    private List<TimeAndWeightRes> timeAndWeightRes;
    @ApiModelProperty(value = "사용자 업로드 카드")
    private List<UserUploadImgRes> userUploadImgRes;
}
