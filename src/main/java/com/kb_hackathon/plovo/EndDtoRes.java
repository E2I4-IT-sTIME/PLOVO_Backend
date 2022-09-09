package com.kb_hackathon.plovo;

import lombok.Builder;

import java.util.List;

@Builder
public class EndDtoRes {

    private String m_name;
    private String date;
    private Float distance;
    private String time;
    private Double weight;
    private List<String> weights; // 6개월치 무게 수치
}
