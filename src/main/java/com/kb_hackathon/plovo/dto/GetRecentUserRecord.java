package com.kb_hackathon.plovo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetRecentUserRecord {
    private String distance;
    private String plovoTime;
    private Double weight;
    private String mName;
    private String mainImg;
}
