package com.kb_hackathon.plovo.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Mountain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "mountain", cascade = CascadeType.ALL)
    private Plovo plovo;

    @Column(name = "m_name")
    private String mName;

    @Column(name = "main_img")
    private String mainImg;

    @Column(name = "map_img")
    private String mapImg;

    private Float distance;
}
