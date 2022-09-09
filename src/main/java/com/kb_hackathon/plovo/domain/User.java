package com.kb_hackathon.plovo.domain;

import lombok.*;
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
    private int id;

    private String k_username; // 소셜로그인에서 받아온 유저네임

    @Column(nullable = false)
    private String username; // 서비스 내의 유저네임

    private String image;

    private Boolean status;

    @CreationTimestamp
    private Timestamp createDate;

}
