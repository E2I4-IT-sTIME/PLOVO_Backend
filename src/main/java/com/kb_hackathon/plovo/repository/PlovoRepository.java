package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.domain.Mountain;
import com.kb_hackathon.plovo.domain.Plovo;
import com.kb_hackathon.plovo.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlovoRepository extends JpaRepository<Plovo, Long> {
    public Plovo findByIdAndDate(Long id, String date);
    public Plovo findByMountain(Mountain mountain);
}
