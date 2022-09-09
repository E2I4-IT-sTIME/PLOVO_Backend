package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.Plovo;
import com.kb_hackathon.plovo.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlovoRepository extends JpaRepository<Plovo, Long> {
    Plovo findByIdAndDate(Long id, String date);
}
