package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.service.PlogService;
import com.kb_hackathon.plovo.domain.Mountain;
import com.kb_hackathon.plovo.dto.EndRes;
import com.kb_hackathon.plovo.dto.GetHomeRes;
import com.kb_hackathon.plovo.dto.GetMountainRes;
import com.kb_hackathon.plovo.dto.GetPlovoMountainRes;
import com.kb_hackathon.plovo.service.MountainService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlogController {

    private final PlogService plogService;

    // 플로보로부터 무게 받아오기 (ex 아두이노)
    @GetMapping("/plovo/weight")
    @ApiOperation(value = "플로보에게 무게 받아오기 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userRecord_id", value = "userRecord 아이디", required = true, dataType = "long"),
            @ApiImplicitParam(name = "plovo_id", value = "플로보 아이디", required = true, dataType = "long"),
            @ApiImplicitParam(name = "weight", value = "플로깅 무게", required = true, dataType = "string")
    })
    public void plovoWeight(@RequestParam(value = "userRecord_id") Long userRecord_id, @RequestParam(value = "plovo_id") Long plovo_id, @RequestParam(value = "weight") String weight) {
        plogService.plovoWeight(userRecord_id, plovo_id, weight);
    }

    // 플로보 완료 api (무게 페이지)
    @GetMapping("/auth/plog/weight")
    @ApiOperation(value = "플로보 완료 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userRecord_id", value = "userRecord 아이디", required = true, dataType = "long"),
            @ApiImplicitParam(name = "time", value = "플로깅 시간", required = true, dataType = "string")
    })
    public String plovoWeight(@RequestParam(value = "userRecord_id") Long userRecord_id, @RequestParam(value = "time") String time, Authentication authentication) {
        String weight = plogService.endWeight(userRecord_id, time);
        return weight;
    }

    // 플로보 위치 확인 api
    @GetMapping("/auth/plog/site")
    @ApiOperation(value = "플로보 위치 확인 API")
    @ApiImplicitParam(name = "plovo_id", value = "userRecord 아이디", required = true, dataType = "long")
    public String plovoSite(@RequestParam(value = "plovo_id") Long plovo_id) {
        return plogService.plovoSite(plovo_id);
    }

    // 종료 api
    @GetMapping("/auth/plog/end")
    @ApiOperation(value = "플로깅 종료 API")
    @ApiImplicitParam(name = "userRecord_id", value = "플로보 아이디", required = true, dataType = "long")
    public EndRes end(@RequestParam(value = "userRecord_id") Long userRecord_id) {
        return plogService.end(userRecord_id);
    }
}
