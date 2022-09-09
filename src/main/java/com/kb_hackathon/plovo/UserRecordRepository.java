package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.User;
import com.kb_hackathon.plovo.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
    UserRecord findByUser(long id);
}
