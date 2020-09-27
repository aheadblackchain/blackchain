package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author solfeng
 * @date 2020/9/25 10:41
 */
public interface CurriculumDao extends JpaRepository<Curriculum,Long> {
}
