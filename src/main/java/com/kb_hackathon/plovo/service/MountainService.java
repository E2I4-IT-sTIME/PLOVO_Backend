package com.kb_hackathon.plovo.service;

import com.kb_hackathon.plovo.domain.Mountain;
import com.kb_hackathon.plovo.domain.Plovo;
import com.kb_hackathon.plovo.domain.UserRecord;
import com.kb_hackathon.plovo.dto.GetHomeRes;
import com.kb_hackathon.plovo.dto.GetMountainRes;
import com.kb_hackathon.plovo.dto.GetPlovoMountainRes;
import com.kb_hackathon.plovo.dto.GetRecentUserRecord;
import com.kb_hackathon.plovo.repository.MountainRepository;
import com.kb_hackathon.plovo.repository.PlovoRepository;
import com.kb_hackathon.plovo.repository.UserRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MountainService {

    private final MountainRepository mountainRepository;
    private final UserRecordRepository userRecordRepository;
    private final PlovoRepository plovoRepository;

    @Transactional(readOnly = true)
    public GetHomeRes home(){
        // 플로깅 산 추천 & 최근 업데이트 플로거 보내주기
        List<Mountain> mountainList = mountainRepository.mRecommend();
        List<UserRecord> userRecords = userRecordRepository.mfindRecent();

        List<GetMountainRes> getMountainRes = new ArrayList<>();
        for (Mountain m : mountainList){
            GetMountainRes getMountainRes1 = GetMountainRes.builder()
                    .mName(m.getMName())
                    .mImage(m.getMainImg())
                    .weight(m.getPlovo().getWeight()).build();
            getMountainRes.add(getMountainRes1);
        }
        List<GetRecentUserRecord> getRecentUserRecords = new ArrayList<>();
        for (UserRecord record : userRecords){
            Optional<Plovo> plovo = plovoRepository.findById(record.getPlovoId());
            Mountain mountain = mountainRepository.findByMName(plovo.get().getMountain().getMName());
            GetRecentUserRecord getRecentPlovo = GetRecentUserRecord.builder()
                    .distance(record.getDistance())
                    .plovoTime(record.getTime())
                    .weight(record.getWeight())
                    .mName(mountain.getMName())
                    .mainImg(mountain.getMainImg()).build();
            getRecentUserRecords.add(getRecentPlovo);

        }

        GetHomeRes getHomeRes = GetHomeRes.builder()
                .getMountainResList(getMountainRes)
                .getRecentPlovos(getRecentUserRecords).build();
        return getHomeRes;
    }

    @Transactional(readOnly = true)
    public List<GetMountainRes> recommend(){
        List<Mountain> mountainList = mountainRepository.mRecommend();
        List<GetMountainRes> getMountainResList = (List<GetMountainRes>) new GetMountainRes();

        for (Mountain m : mountainList){
            GetMountainRes getMountainRes = GetMountainRes.builder()
                    .mName(m.getMName())
                    .mImage(m.getMainImg())
                    .weight(m.getPlovo().getWeight()).build();
            getMountainResList.add(getMountainRes);
        }
        return getMountainResList;
    }

    @Transactional(readOnly = true)
    public List<Mountain> search(String mName){
        return mountainRepository.mfindByMName(mName);
    }

    @Transactional(readOnly = true)
    public GetPlovoMountainRes plogStart(String mName){
        Mountain mountain = mountainRepository.findByMName(mName);
        GetPlovoMountainRes getPlovoMountainRes = GetPlovoMountainRes.builder()
                .mName(mountain.getMName())
                .mapImg(mountain.getMapImg())
                .distance(mountain.getDistance())
                .plovoWeight(mountain.getPlovo().getWeight()).build();
        return getPlovoMountainRes;

    }
}
