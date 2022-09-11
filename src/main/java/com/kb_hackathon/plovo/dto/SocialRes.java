package com.kb_hackathon.plovo.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class SocialRes {

    private List<String> recentPlog;
    private List<String> bestPlogger;
}
