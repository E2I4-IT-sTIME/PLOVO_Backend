package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.config.S3Uploader;
import com.kb_hackathon.plovo.dto.RecordRes;
import com.kb_hackathon.plovo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "사용자 기록 페이지 API")
    @ApiImplicitParam(name = "user_id", value = "유저 아이디", required = true, dataType = "long")
    public RecordRes myRecord(@RequestParam(value = "user_id") Long user_id, Authentication authentication) {
        return userService.myRecord(user_id);
    }
}
