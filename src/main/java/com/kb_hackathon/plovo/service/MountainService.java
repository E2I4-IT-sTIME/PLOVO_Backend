package com.kb_hackathon.plovo.service;

import com.kb_hackathon.plovo.domain.Mountain;
import com.kb_hackathon.plovo.domain.Plovo;
import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.domain.UserRecord;
import com.kb_hackathon.plovo.dto.GetHomeRes;
import com.kb_hackathon.plovo.dto.GetMountainRes;
import com.kb_hackathon.plovo.dto.GetPlovoMountainRes;
import com.kb_hackathon.plovo.dto.GetRecentUserRecord;
import com.kb_hackathon.plovo.repository.EntityManagerQuery;
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
    private final EntityManagerQuery entityManagerQuery;

    @Transactional(readOnly = true)
    public GetHomeRes home(){
        // 플로깅 산 추천 & 최근 업데이트 플로거 보내주기
        List<GetMountainRes> mountainList = entityManagerQuery.mRecommend();
        List<UserRecord> userRecords = userRecordRepository.mfindRecent();

        List<GetRecentUserRecord> getRecentUserRecords = new ArrayList<>();
        for (UserRecord record : userRecords){
            Optional<Plovo> plovo = plovoRepository.findById(record.getPlovoId());
            Mountain mountain = mountainRepository.findBymName(plovo.get().getMountain().getMName());
            GetRecentUserRecord getRecentPlovo = GetRecentUserRecord.builder()
                    .distance(record.getDistance())
                    .plovoTime(record.getTime())
                    .weight(record.getWeight())
                    .mName(mountain.getMName())
                    .mainImg(mountain.getMainImg()).build();
            getRecentUserRecords.add(getRecentPlovo);

        }

        GetHomeRes getHomeRes = GetHomeRes.builder()
                .getMountainResList(mountainList)
                .getRecentPlovos(getRecentUserRecords).build();
        return getHomeRes;
    }

    @Transactional(readOnly = true)
    public List<GetMountainRes> recommend(){
        List<GetMountainRes> mountainList = entityManagerQuery.mRecommend();

        return mountainList;
    }

    @Transactional(readOnly = true)
    public List<Mountain> search(String mName){
        return mountainRepository.mfindBymName(mName);
    }

    @Transactional
    public GetPlovoMountainRes plogStart(String mName, User user){
        Mountain mountain = mountainRepository.findBymName(mName);

        Plovo plovo = plovoRepository.findByMountain(mountain);

        UserRecord userRecord = UserRecord.builder()
                .user(user)
                .plovoId(plovo.getId())
                .distance(mountain.getDistance()).build();

        userRecordRepository.save(userRecord);

        GetPlovoMountainRes getPlovoMountainRes = GetPlovoMountainRes.builder()
                .mName(mountain.getMName())
                .mapImg(mountain.getMapImg())
                .distance(mountain.getDistance())
                .plovoWeight(mountain.getPlovo().getWeight())
                .userRecord_id(userRecord.getId()).build();

        return getPlovoMountainRes;

    }
}
