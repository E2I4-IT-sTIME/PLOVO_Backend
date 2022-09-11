package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.domain.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MountainRepository extends JpaRepository<Mountain, Long> {

    @Query(value = "SELECT * FROM mountain ORDER BY plovoWeight DESC LIMIT 5", nativeQuery = true)
    List<Mountain> mRecommend();

    @Query(value = "SELECT * FROM mountain WHERE mName like %mName = :mName%", nativeQuery = true)
    List<Mountain> mfindByMName(String mName);

    Mountain findByMName(String mName);

}
