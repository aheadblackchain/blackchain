package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author solfeng
 * @date 2020/9/25 17:14
 */
public interface  ProjectDao  extends JpaRepository<Project,Long> {
    @Query(nativeQuery = true, value = "select * from tab_project limit 0,5")
    public List<Project> findProjectLimit();
}

