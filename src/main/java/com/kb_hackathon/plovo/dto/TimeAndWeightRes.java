package com.kb_hackathon.plovo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeAndWeightRes {
    private Integer month;
    private Integer day;
    private String time;
    private String weight;
}
