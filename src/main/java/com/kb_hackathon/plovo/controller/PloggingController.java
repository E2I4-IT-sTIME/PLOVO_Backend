package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.domain.Mountain;
import com.kb_hackathon.plovo.dto.GetHomeRes;
import com.kb_hackathon.plovo.dto.GetMountainRes;
import com.kb_hackathon.plovo.dto.GetPlovoMountainRes;
import com.kb_hackathon.plovo.dto.GetRecentUserRecord;
import com.kb_hackathon.plovo.service.MountainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PloggingController {

    private final MountainService mountainService;

    @GetMapping("/home")
    public GetHomeRes home(){
        return mountainService.home();
    }

    @GetMapping("/plog/recommend")
    public List<GetMountainRes> recommend(){
        return mountainService.recommend();
    }

    @PostMapping("/plog/search")
    public List<Mountain> search(@RequestParam String mName){
        return mountainService.search(mName);
    }

    @GetMapping("/plog/start")
    public GetPlovoMountainRes plogStart(@RequestParam String mName){  // 산 선택해서 산이름 넘어오면
        return mountainService.plogStart(mName);
    }

}
