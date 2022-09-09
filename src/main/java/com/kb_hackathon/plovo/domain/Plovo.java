package com.kb_hackathon.plovo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Plovo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String site;

    private Double weight; // 최종 무게

    @Column(name = "current_weight")
    private Double currentWeight; // 현재 측정된 무게

    private String img;
}
