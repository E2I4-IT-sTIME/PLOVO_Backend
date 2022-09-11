package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {

    @Query(value = "SELECT * FROM UserRecord ORDER BY createDate DESC LIMIT 5", nativeQuery = true)
    List<UserRecord> mfindRecent();
}
