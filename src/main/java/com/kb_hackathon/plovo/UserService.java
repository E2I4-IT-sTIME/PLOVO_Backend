package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRecordRepository userRecordRepository;


    public RecordRes myRecord(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);

        List<String> time = userRecordRepository.timesAsc(user.get().getId());
        List<String> weight = userRecordRepository.weightsAsc(user.get().getId());

        RecordRes recordRes = RecordRes.builder()
                .username(user.get().getUsername())
                .profileImg(user.get().getImage())
                .time(time)
                .weight(weight)
                .build();

        return recordRes;
    }

}
