package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.Plovo;
import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.domain.UserRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlogService {

    private final UserRecordRepository userRecordRepository;
    private final PlovoRepository plovoRepository;

    // 플로보로부터 무게 받아오기 (ex 아두이노)
    @Transactional
    public Double plovoWeight(Long user_id, Long plovo_id, Double weight) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String formatedNow = now.format(formatter);

        UserRecord userRecord = userRecordRepository.findByUser(user_id);
        Plovo plovo = plovoRepository.findByIdAndDate(plovo_id, formatedNow);

        plovo.setWeight(plovo.getWeight() + weight);
        userRecord.setWeight(weight);

        return weight;
    }

    @Transactional
    public Double endWeight(User user, String time) {
        UserRecord userRecord = userRecordRepository.findByUser(user.getId());
        userRecord.setTime(time);

        return userRecord.getWeight();
    }

}
