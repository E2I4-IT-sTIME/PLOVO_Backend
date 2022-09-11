package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.service.SocialService;
import com.kb_hackathon.plovo.dto.SocialRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SocialController {

    private final SocialService socialService;

    // 소셜 페이지 api
    @GetMapping("/social")
    public SocialRes social() {
        return socialService.social();
    }
}
