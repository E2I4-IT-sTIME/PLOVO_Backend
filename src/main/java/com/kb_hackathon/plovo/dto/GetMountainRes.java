package com.kb_hackathon.plovo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMountainRes {
    private String mName;  // 산 이름
    private String mImage;  // 산 이미지
    private Double weight;  // 현재 플로보 무게
}
