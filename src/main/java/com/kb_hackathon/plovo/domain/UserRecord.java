package com.kb_hackathon.plovo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table
public class UserRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private User user;

    @Column(name = "date")
    private String date;

    @Column(name = "plovo_time")
    private String plovoTime;

    @Column(name = "weight")
    private String weight;

    @Column(name = "m_name")
    private String m_name;
}
