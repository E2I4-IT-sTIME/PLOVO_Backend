package com.kb_hackathon.plovo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPlovoMountainRes {
    private String mName;
    private String mapImg;
    private String distance;
    private Double plovoWeight;
}
