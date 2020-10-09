package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.ProjectDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDescriptionDao extends JpaRepository<ProjectDescription, Long> {
}
