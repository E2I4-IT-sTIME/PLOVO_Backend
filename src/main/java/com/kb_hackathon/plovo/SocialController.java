package com.kb_hackathon.plovo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
