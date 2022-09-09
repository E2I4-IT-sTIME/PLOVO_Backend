package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class PlogController {

    private final PlogService plogService;

    // 플로보로부터 무게 받아오기 (ex 아두이노)
    @GetMapping("/weight")
    public void plovoWeight(@RequestParam(value = "user_id") Long user_id, @RequestParam(value = "plovo_id") Long plovo_id, @RequestParam(value = "weight") Double weight) {
        plogService.plovoWeight(user_id, plovo_id, weight);
    }

    // 플로보 완료 api (무게 페이지)
    @GetMapping("/auth/plog/weight")
    public Double plovoWeight(@RequestParam(value = "plovo_id") Long plovo_id, @RequestParam(value = "time") String time, Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        Double weight = plogService.plovoWeight(principalDetails.getUser(), time, plovo_id);
        return weight;
    }

    // 플로보 위치 확인 api
    @GetMapping("/auth/plog/site")

    // 종료 api
    @GetMapping("/auth/plog/end")
}
