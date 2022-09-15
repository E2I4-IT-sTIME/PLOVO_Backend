package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.domain.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MountainRepository extends JpaRepository<Mountain, Long> {

    Mountain findBymName(String mName);

}
