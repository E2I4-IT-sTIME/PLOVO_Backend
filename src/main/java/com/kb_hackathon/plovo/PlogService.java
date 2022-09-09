package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.Plovo;
import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.domain.UserRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlogService {

    private final UserRecordRepository userRecordRepository;
    private final PlovoRepository plovoRepository;

    // 플로보로부터 무게 받아오기 (ex 아두이노)
    @Transactional
    public Double plovoWeight(Long userRecord_id, Long plovo_id, Double weight) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String formatedNow = now.format(formatter);

        Optional<UserRecord> userRecord = userRecordRepository.findById(userRecord_id);
        Plovo plovo = plovoRepository.findByIdAndDate(plovo_id, formatedNow);

        plovo.setWeight(plovo.getWeight() + weight);
        userRecord.get().setWeight(weight);

        return weight;
    }

    @Transactional
    public Double endWeight(Long userRecord_id, String time) {
        Optional<UserRecord> userRecord = userRecordRepository.findById(userRecord_id);
        userRecord.get().setTime(time);

        return userRecord.get().getWeight();
    }

    public String plovoSite(Long plovo_id) {
        Optional<Plovo> plovo = plovoRepository.findById(plovo_id);

        return plovo.get().getImg();
    }

    public EndDtoRes end(Long userRecord_id) {
        Optional<UserRecord> userRecord = userRecordRepository.findById(userRecord_id);
        Optional<Plovo> plovo = plovoRepository.findById(userRecord.get().getPlovoId());

        List<String> weights = plovoRepository.monthsAsc(plovo.get().getId());

        EndDtoRes endDtoRes = EndDtoRes.builder()
                .m_name(plovo.get().getMountain().getMName())
                .date(userRecord.get().getDate().toString())
                .distance(plovo.get().getMountain().getDistance())
                .time(userRecord.get().getTime())
                .weight(userRecord.get().getWeight())
                .weights(weights).build();

        return endDtoRes;
    }

}
