package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.config.auth.PrincipalDetails;
import com.kb_hackathon.plovo.domain.Mountain;
import com.kb_hackathon.plovo.dto.*;
import com.kb_hackathon.plovo.service.MountainService;
import com.kb_hackathon.plovo.service.SocialService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MountainController {
    private final MountainService mountainService;

    @GetMapping("/home")
    public GetHomeRes home(){
        return mountainService.home();
    }

    @GetMapping("/mountain/recommend")
    public List<MountainRes> recommend(){
        return mountainService.recommend();
    }

    @PostMapping("/mountain/search")
    public List<GetMountainRes> search(@RequestParam("mName") String mName){
        return mountainService.search(mName);
    }

    @GetMapping("/auth/plog/start")
    @ApiOperation(value = "플로깅 시작 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mName", value = "산 이름", required = true, dataType = "string")
    })
    public GetPlovoMountainRes plogStart(@RequestParam("mName") String mName, Authentication authentication){  // 산 선택해서 산이름 넘어오면
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();

        return mountainService.plogStart(mName, principalDetails.getUser());
    }
}
