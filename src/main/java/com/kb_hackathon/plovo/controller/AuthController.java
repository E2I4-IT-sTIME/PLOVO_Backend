package com.kb_hackathon.plovo.controller;

import com.kb_hackathon.plovo.config.jwt.JwtProperties;
import com.kb_hackathon.plovo.config.oauth.AccessTokenRes;
import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.service.AuthService;
import com.kb_hackathon.plovo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
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
    private final AuthService authService;

    // 프론트 -> 서버 로 인가코드 전송하면 받아오는 URI
    // 임시 URI 경로
    // https://kauth.kakao.com/oauth/authorize?client_id=b9f6eaeb47ed2f08476461345671880c&redirect_uri=http://52.78.4.217:8080/api/authorization_code&response_type=code
    // https://kauth.kakao.com/oauth/authorize?client_id=b9f6eaeb47ed2f08476461345671880c&redirect_uri=http://localhost:8080/api/authorization_code&response_type=code
    @GetMapping("/api/authorization_code")
    public ResponseEntity getLogin(@RequestParam("code") String code) {

        // 인가코드 받았으니 이를 가지고 카카오서버에게 액세스 토큰 발급 요청
        AccessTokenRes accessTokenRes = authService.getAccessToken(code);

        // 액세스 토큰 발급 완료

        // 발급 받은 accessToken 으로 카카오 서버에 회원정보 요청 후 DB에 저장
        String jwtToken = authService.saveUser(accessTokenRes.getAccess_token());

        System.out.println("access_token : " + accessTokenRes.getAccess_token());
        System.out.println("jwtToken : Bearer " + jwtToken);

        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);

        return ResponseEntity.ok().headers(headers).body("success");
    }

    @GetMapping("/api/code")
    public ResponseEntity code(@RequestParam("code") String code) {
        return ResponseEntity.ok().body("success");
    }

    // 인가코드 과정 없이 바로 액세스코드 받아오기
    @GetMapping("/api/access_token")
    public ResponseEntity getToken(@RequestParam("token") String token) {

        String jwtToken = authService.saveUser(token);

        System.out.println("jwtToken : Bearer " + jwtToken);

        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);

        return ResponseEntity.ok().headers(headers).body("success");
    }

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
