package com.kb_hackathon.plovo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    // 기록 페이지 api
    @GetMapping("/auth/record")
}
