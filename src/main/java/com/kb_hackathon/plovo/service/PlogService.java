package com.kb_hackathon.plovo.service;

import com.kb_hackathon.plovo.domain.Mountain;
import com.kb_hackathon.plovo.domain.Plovo;
import com.kb_hackathon.plovo.domain.UserRecord;
import com.kb_hackathon.plovo.dto.EndRes;
import com.kb_hackathon.plovo.dto.MonthAndWeightRes;
import com.kb_hackathon.plovo.repository.EntityManagerQuery;
import com.kb_hackathon.plovo.repository.MountainRepository;
import com.kb_hackathon.plovo.repository.PlovoRepository;
import com.kb_hackathon.plovo.repository.UserRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.stream.events.EntityDeclaration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PlogService {

    private final UserRecordRepository userRecordRepository;
    private final PlovoRepository plovoRepository;
    private final MountainRepository mountainRepository;
    private final EntityManagerQuery entityManagerQuery;

    // 플로보로부터 무게 받아오기 (ex 아두이노)
//    @Transactional
//    public String plovoWeight(Long userRecord_id, Long plovo_id, String weight) {
//        LocalDate now = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
//        String formatedNow = now.format(formatter);
//
//        Optional<UserRecord> userRecord = userRecordRepository.findById(userRecord_id);
//        Plovo plovo = plovoRepository.findByIdAndDate(plovo_id, formatedNow);
//
//        plovo.setWeight(plovo.getWeight() + weight);
//        userRecord.get().setWeight(weight);
//
//        return weight;
//    }

    @Transactional
    public String endWeight(Long userRecord_id, String time) {
        Optional<UserRecord> userRecord = userRecordRepository.findById(userRecord_id);
        userRecord.get().setTime(time);

        Random random = new Random();
        double randomNum = (double) (Math.random() * 201 ) + 100;
        String formatedNum = String.format("%.2f", randomNum);
        userRecord.get().setWeight(formatedNum);

        Optional<Plovo> plovo = plovoRepository.findById(userRecord.get().getPlovoId());
        double sumWeight = Double.valueOf(plovo.get().getWeight())+randomNum;
        String formatedSum = String.format("%.2f", sumWeight);
        plovo.get().setWeight(formatedSum);

        plovoRepository.save(plovo.get());

        return userRecord.get().getWeight();
    }

    public String plovoSite(Long plovo_id) {
        Optional<Plovo> plovo = plovoRepository.findById(plovo_id);

        return plovo.get().getImg();
    }

    public EndRes end(Long userRecord_id) {
        Optional<UserRecord> userRecord = userRecordRepository.findById(userRecord_id);
        Optional<Plovo> plovo = plovoRepository.findById(userRecord.get().getPlovoId());
        Optional<Mountain> mountain = mountainRepository.findById(plovo.get().getMountain().getId());

        List<MonthAndWeightRes> monthAndWeightRes = entityManagerQuery.MonthAndWeightRes(mountain.get().getId());

        System.out.println("weights : " + monthAndWeightRes);

        EndRes endRes = EndRes.builder()
                .m_name(plovo.get().getMountain().getMName())
                .date(userRecord.get().getDate().toString())
                .distance(plovo.get().getMountain().getDistance())
                .time(userRecord.get().getTime())
                .weight(userRecord.get().getWeight())
                .monthAndWeightRes(monthAndWeightRes).build();

        return endRes;
    }

}
