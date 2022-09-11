package com.kb_hackathon.plovo.service;

import com.kb_hackathon.plovo.dto.SocialRes;
import com.kb_hackathon.plovo.repository.UserRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialService {

    private final UserRecordRepository userRecordRepository;

    public SocialRes social() {

        List<String> recentPlog = userRecordRepository.recentPlog();
        List<String> bestPlogger = userRecordRepository.bestPlogger();

        SocialRes socialRes = SocialRes.builder()
                .recentPlog(recentPlog)
                .bestPlogger(bestPlogger).build();

        return socialRes;
    }

}
