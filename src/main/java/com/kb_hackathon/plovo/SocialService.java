package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
