package com.kb_hackathon.plovo.domain;

import java.sql.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class UserRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "plovo_id")
    private Long plovoId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private Timestamp date;

    @Column(name = "time")
    private String time; // 플로깅 걸린 시간

    private Double weight; // 플로보에 담은 무게
}
