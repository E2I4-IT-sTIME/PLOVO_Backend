package com.kb_hackathon.plovo.service;

import com.kb_hackathon.plovo.config.S3Uploader;
import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.dto.RecordRes;
import com.kb_hackathon.plovo.dto.TimeAndWeightRes;
import com.kb_hackathon.plovo.repository.EntityManagerQuery;
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
    private final EntityManagerQuery entityManagerQuery;

    @Transactional
    public void addUsername(Long id, String name){
        Optional<User> user = userRepository.findById(id);
        user.get().setUsername(name);
    }

    @Transactional
    public void addImage(Long id, MultipartFile multipartFile) throws IOException {
        String r = s3Uploader.upload(id, multipartFile, "user");
        System.out.println(r);
    }

    public RecordRes myRecord(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);

        List<TimeAndWeightRes> timeAndWeightRes = entityManagerQuery.timeAndWeight(user.get().getId());

        RecordRes recordRes = RecordRes.builder()
                .username(user.get().getUsername())
                .profileImg(user.get().getProfile_img())
                .timeAndWeightRes(timeAndWeightRes)
                .build();

        return recordRes;
    }
}
