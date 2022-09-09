package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.Plovo;
import com.kb_hackathon.plovo.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlovoRepository extends JpaRepository<Plovo, Long> {
    public Plovo findByIdAndDate(Long id, String date);

    @Query(value = "SELECT p.date, p.weight FROM Plovo p.id = :id WHERE p.date BETWEEN DATE_ADD(NOW(),INTERVAL -6 MONTH) AND NOW()", nativeQuery = true)
    List<String> monthsAsc(@Param("Id") Long id);
}
