package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.domain.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MountainRepository extends JpaRepository<Mountain, Long> {

    @Query(value = "SELECT m.m_name, m.main_img, p.weight FROM mountain m left join plovo p on m.id = p.mountain_id " +
            "ORDER BY p.weight DESC LIMIT 5", nativeQuery = true)
    List<Mountain> mRecommend();

    @Query(value = "SELECT m.m_name, m.main_img, p.weight FROM mountain m left outer join plovo p on m.id = p.mountain_id WHERE m.m_name like '%m.m_name = :mName%'", nativeQuery = true)
    List<Mountain> mfindBymName(String mName);

    Mountain findBymName(String mName);

}
