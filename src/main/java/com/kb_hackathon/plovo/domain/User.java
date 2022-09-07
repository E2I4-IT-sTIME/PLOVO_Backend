package com.kb_hackathon.plovo.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String k_username;

    @Column(nullable = false)
    private String username;

    private String image;

    private Boolean status;

    @CreationTimestamp
    private Timestamp createDate;

}
