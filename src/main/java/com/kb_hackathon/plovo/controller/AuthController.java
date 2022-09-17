package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.config.jwt.JwtProperties;
import com.kb_hackathon.plovo.config.oauth.AccessTokenRes;
import com.kb_hackathon.plovo.dto.LoginRes;
import com.kb_hackathon.plovo.service.AuthService;
import com.kb_hackathon.plovo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    // 프론트 -> 서버 로 인가코드 전송하면 받아오는 URI
    // 임시 URI 경로
    // https://kauth.kakao.com/oauth/authorize?client_id=b9f6eaeb47ed2f08476461345671880c&redirect_uri=http://52.78.4.217:8080/api/authorization_code&response_type=code
    // https://kauth.kakao.com/oauth/authorize?client_id=b9f6eaeb47ed2f08476461345671880c&redirect_uri=http://localhost:8080/api/authorization_code&response_type=code
//    @GetMapping("/api/authorization_code")
//    public ResponseEntity getLogin(@RequestParam("code") String code) {
//
//        // 인가코드 받았으니 이를 가지고 카카오서버에게 액세스 토큰 발급 요청
//        AccessTokenRes accessTokenRes = authService.getAccessToken(code);
//
//        // 액세스 토큰 발급 완료
//
//        // 발급 받은 accessToken 으로 카카오 서버에 회원정보 요청 후 DB에 저장
//        String jwtToken = String.valueOf(authService.saveUser(accessTokenRes.getAccess_token()));
//
//        System.out.println("access_token : " + accessTokenRes.getAccess_token());
//        System.out.println("jwtToken : Bearer " + jwtToken);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);
//
//        return ResponseEntity.ok().headers(headers).body("success");
//    }

    @GetMapping("/api/code")
    @ApiOperation(value = "인가코드 받기 API")
    @ApiImplicitParam(name = "code", value = "인가코드", required = true, dataType = "string")
    public ResponseEntity code(@RequestParam("code") String code) {
        return ResponseEntity.ok().body("success");
    }

    // 인가코드 과정 없이 바로 액세스코드 받아오기
    @GetMapping("/api/access_token")
    @ApiOperation(value = "엑세스 코드 받기 API")
    @ApiImplicitParam(name = "token", value = "엑세스 코드", required = true, dataType = "string")
    public ResponseEntity getToken(@RequestParam("token") String token) {

        LoginRes loginRes = authService.saveUser(token);

        System.out.println("jwtToken : Bearer " + loginRes.getJwtToken());

        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + loginRes.getJwtToken());

        return ResponseEntity.ok().headers(headers).body(loginRes);
    }

    @PostMapping("/join/{id}/username")
    @ApiOperation(value = "추가정보입력(이름) API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "유저 아이디", paramType = "path", required = true, dataType = "long"),
            @ApiImplicitParam(name = "name", value = "유저 이름", required = true, dataType = "string")
    })
    public void addInfoName(@PathVariable Long id, @RequestParam("name") String name) {
        userService.addUsername(id, name);
    }

    @PostMapping("/join/{id}/image")
    @ApiOperation(value = "추가정보입력(이미지) API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "유저 아이디", paramType = "path", required = true, dataType = "long"),
            @ApiImplicitParam(name = "image", value = "유저 이미지", required = true, dataType = "multipartFile")
    })
    public void addInfoImage(@PathVariable Long id, @RequestPart(value = "image", required = false) MultipartFile multipartFile) throws IOException {
        userService.addImage(id, multipartFile);

    }
}
