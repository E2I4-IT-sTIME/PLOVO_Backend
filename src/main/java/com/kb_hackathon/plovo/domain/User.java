package com.kb_hackathon.plovo.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String k_username; // 소셜로그인에서 받아온 유저네임

    @Column(nullable = true)
    private String username; // 서비스 내의 유저네임

    private String email;

    private String profile_img;

    private String role;

    @ColumnDefault("'ACTIVE'")
    private String status;

    @CreationTimestamp
    private Timestamp create_date;

    public void setImage(String image){
        this.profile_img = image;
    }

    @Builder
    public User(String kakao_username, String username, String email, String profileImg, String role) {
        this.k_username = kakao_username;
        this.username = username;
        this.email = email;
        this.profile_img = profileImg;
        this.role = role;
    }
}
