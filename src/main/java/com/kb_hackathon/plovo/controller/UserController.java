package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.config.S3Uploader;
import com.kb_hackathon.plovo.dto.RecordRes;
import com.kb_hackathon.plovo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 기록 페이지 api
    @GetMapping("/auth/record")
    public RecordRes myRecord(@RequestParam(value = "user_id") Long user_id, Authentication authentication) {
        return userService.myRecord(user_id);
    }
}
