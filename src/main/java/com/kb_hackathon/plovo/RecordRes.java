package com.kb_hackathon.plovo;

import lombok.Builder;

import java.util.List;

@Builder
public class RecordRes {

    private String username;
    private String profileImg;
    private List<String> time;
    private List<String> weight;
}
