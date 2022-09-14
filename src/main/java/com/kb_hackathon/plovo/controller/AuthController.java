package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/{id}/name")
    public void addInfoName(@PathVariable Long id, @RequestParam("name") String name) {
        userService.addUsername(id, name);
    }

    @PostMapping("/{id}/profileImage")
    public ResponseEntity addInfoImage(@PathVariable Long id, @RequestPart(value = "image", required = false) MultipartFile multipartFile) {
        try {
            userService.addImage(id, multipartFile);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
