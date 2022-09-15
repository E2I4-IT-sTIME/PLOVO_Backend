package com.kb_hackathon.plovo.domain;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_record")
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
    
    private String distance;

    @Column(name = "time")
    private String time; // 플로깅 걸린 시간

    private String weight; // 플로보에 담은 무게

}
