package com.kb_hackathon.plovo.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Plovo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "plovo")
    private Mountain mountain;

    private Double weight; // 최종 무게

    @Column(name = "current_weight")
    private Double currentWeight; // 현재 측정된 무게 -> 사용x 필드?

    private String img;

    @DateTimeFormat(pattern="yyyy-MM")
    private Timestamp date;
}
