package com.kb_hackathon.plovo.service;

import com.kb_hackathon.plovo.config.S3Uploader;
import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.dto.RecordRes;
import com.kb_hackathon.plovo.repository.UserRecordRepository;
import com.kb_hackathon.plovo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRecordRepository userRecordRepository;
    private final S3Uploader s3Uploader;

    @Transactional
    public User addUsername(String username){
        User user = User.builder()
                .username(username)
                .k_username(username)  // 카카오에서 받아온 이름으로 변경하기
                .status(true).build();
        return user;
    }

    @Transactional
    public void addImage(MultipartFile multipartFile, User user) throws IOException {
        String r = s3Uploader.upload(user.getId(), multipartFile, "user");
        System.out.println(r);
    }

    public RecordRes myRecord(int user_id) {
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
