package com.kb_hackathon.plovo.service;

import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
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
}
