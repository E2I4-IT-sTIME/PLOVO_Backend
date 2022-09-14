package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
