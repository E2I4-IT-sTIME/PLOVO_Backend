package com.kb_hackathon.plovo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table
public class Mountain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "m_name")
    private String mName;

    @Column(name = "main_img")
    private String mainImg;

    @Column(name = "map_img")
    private String mapImg;

    @Column(name = "plovo_img")
    private String plovoImg;

    @Column(name = "plovo_weight")
    private String plovoWeight;

    @Column(name = "distance")
    private String distance;
}
