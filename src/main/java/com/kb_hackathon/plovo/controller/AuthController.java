package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/join/username")
    public User AddUsername(@RequestParam("username") String username){
        return userService.addUsername(username);
    }

    @PostMapping("/join/image")
    public void AddImage(@RequestPart(value = "image", required = false)MultipartFile multipartFile, User user) throws IOException {
        userService.addImage(multipartFile, user);
    }
}
