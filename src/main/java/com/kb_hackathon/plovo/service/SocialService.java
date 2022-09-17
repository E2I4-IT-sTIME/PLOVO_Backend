package com.kb_hackathon.plovo.service;

import com.kb_hackathon.plovo.dto.BestPloggerRes;
import com.kb_hackathon.plovo.dto.GetMountainRes;
import com.kb_hackathon.plovo.dto.PlogMountainInfoRes;
import com.kb_hackathon.plovo.dto.SocialRes;
import com.kb_hackathon.plovo.repository.EntityManagerQuery;
import com.kb_hackathon.plovo.repository.UserRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialService {

    private final UserRecordRepository userRecordRepository;
    private final EntityManagerQuery entityManagerQuery;

    public SocialRes social() {

        List<PlogMountainInfoRes> recentPlog = entityManagerQuery.recentPlogInfo();
        List<BestPloggerRes> bestPlogger = entityManagerQuery.bestPlogger();

        SocialRes socialRes = SocialRes.builder()
                .recentPlog(recentPlog)
                .bestPlogger(bestPlogger).build();

        return socialRes;
    }

}
