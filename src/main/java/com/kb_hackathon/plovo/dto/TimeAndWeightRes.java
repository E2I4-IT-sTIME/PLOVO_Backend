package com.kb_hackathon.plovo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeAndWeightRes {
    private Integer month;
    private BigDecimal time;
    private Double weight;
}
