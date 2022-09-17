package com.kb_hackathon.plovo.service;

import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.dto.BestPloggerRes;
import com.kb_hackathon.plovo.dto.GetMountainRes;
import com.kb_hackathon.plovo.dto.PlogMountainInfoRes;
import com.kb_hackathon.plovo.dto.SocialRes;
import com.kb_hackathon.plovo.repository.EntityManagerQuery;
import com.kb_hackathon.plovo.repository.UserRecordRepository;
import com.kb_hackathon.plovo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocialService {

    private final UserRecordRepository userRecordRepository;
    private final EntityManagerQuery entityManagerQuery;
    private final UserRepository userRepository;

    public SocialRes social() {

        List<PlogMountainInfoRes> recentPlog1 = entityManagerQuery.recentPlogInfo("광교산");
        List<PlogMountainInfoRes> recentPlog2 = entityManagerQuery.recentPlogInfo("수리산");
        List<PlogMountainInfoRes> recentPlog3 = entityManagerQuery.recentPlogInfo("불곡산");



        List<BestPloggerRes> bestPlogger = entityManagerQuery.bestPlogger();

        for (PlogMountainInfoRes info : recentPlog1){
            if (info.getUploadImg() == null){
                info.setUploadImg("https://plovo.s3.ap-northeast-2.amazonaws.com/KakaoTalk_20220918_032111258.png");
            }
        }

        for (PlogMountainInfoRes info : recentPlog2){
            if (info.getUploadImg() == null){
                info.setUploadImg("https://plovo.s3.ap-northeast-2.amazonaws.com/KakaoTalk_20220918_032111258.png");
            }
        }

        for (PlogMountainInfoRes info : recentPlog3){
            if (info.getUploadImg() == null){
                info.setUploadImg("https://plovo.s3.ap-northeast-2.amazonaws.com/KakaoTalk_20220918_032111258.png");
            }
        }

        for (BestPloggerRes bp: bestPlogger){
            if (bp.getProfile_img() == null){
                bp.setProfile_img("https://plovo.s3.ap-northeast-2.amazonaws.com/KakaoTalk_20220918_032235888.png");
            }
        }

        SocialRes socialRes = SocialRes.builder()
                .recentPlog1(recentPlog1)
                .recentPlog2(recentPlog2)
                .recentPlog3(recentPlog3)
                .bestPlogger(bestPlogger).build();

        return socialRes;
    }

}
