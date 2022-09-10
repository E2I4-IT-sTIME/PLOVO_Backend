package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {

    @Query(value = "SELECT * FROM USERRECORD LIMIT 5 ORDER BY createDate DESC", nativeQuery = true)
    List<UserRecord> mfindRecent();
}
