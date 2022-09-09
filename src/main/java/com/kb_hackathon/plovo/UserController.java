package com.kb_hackathon.plovo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
