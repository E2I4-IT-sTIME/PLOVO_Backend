package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
    public UserRecord findByUser(long id);

    @Query(value = "SELECT u.date, u.time FROM UserRecord u WHERE u.user = :user_id and u.date BETWEEN DATE_ADD(NOW(),INTERVAL -6 DAY) AND NOW()", nativeQuery = true)
    public List<String> timesAsc(long user_id);

    @Query(value = "SELECT u.date, u.weight FROM UserRecord u WHERE u.user = :user_id and u.date BETWEEN DATE_ADD(NOW(),INTERVAL -6 DAY) AND NOW()", nativeQuery = true)
    public List<String> weightsAsc(long user_id);
}
