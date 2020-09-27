package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author solfeng
 * @date 2020/9/25 17:14
 */
public interface  ProjectDao  extends JpaRepository<Project,Long> {
}
