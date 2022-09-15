package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {

    @Query(value = "SELECT * FROM UserRecord ur ORDER BY ur.date DESC LIMIT 5", nativeQuery = true)
    List<UserRecord> mfindRecent();

    @Query(value = "SELECT u.date, u.time FROM UserRecord u WHERE u.user = :user_id and u.date BETWEEN DATE_ADD(NOW(),INTERVAL -6 DAY) AND NOW()", nativeQuery = true)
    public List<String> timesAsc(long user_id);

    @Query(value = "SELECT u.date, u.weight FROM UserRecord u WHERE u.user = :user_id and u.date BETWEEN DATE_ADD(NOW(),INTERVAL -6 DAY) AND NOW()", nativeQuery = true)
    public List<String> weightsAsc(long user_id);

    @Query(value = "SELECT m.m_name, m.distance, u.time, u.weight FROM user_record u left outer join plovo p on u.plovo_id = p.id\n" +
            "left join mountain m on p.mountain_id = m.id ORDER BY u.date DESC LIMIT 3;", nativeQuery = true)
    public List<String> recentPlog();

    @Query(value = "SELECT u.username FROM user_record ur JOIN user u ON ur.user_id = u.id " +
            "GROUP BY u.id ORDER BY COUNT(*) DESC LIMIT 6;", nativeQuery = true)
    public List<String> bestPlogger();
}
