package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.domain.UserRecord;
import com.kb_hackathon.plovo.dto.MonthAndWeightRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {

    @Query(value = "SELECT * FROM user_record ur ORDER BY ur.date DESC LIMIT 5", nativeQuery = true)
    List<UserRecord> mfindRecent();

}
