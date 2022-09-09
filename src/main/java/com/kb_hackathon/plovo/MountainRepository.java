package com.kb_hackathon.plovo;

import com.kb_hackathon.plovo.domain.Mountain;
import com.kb_hackathon.plovo.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainRepository extends JpaRepository<Mountain, Long> {
}
