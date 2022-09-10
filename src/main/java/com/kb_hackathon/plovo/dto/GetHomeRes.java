package com.kb_hackathon.plovo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetHomeRes {
    private List<GetMountainRes> getMountainResList;
    private List<GetRecentUserRecord> getRecentPlovos;
}
