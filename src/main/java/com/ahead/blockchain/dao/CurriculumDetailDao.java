package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.CurriculumDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author solfeng
 * @date 2020/9/28 20:21
 */
public interface CurriculumDetailDao extends JpaRepository<CurriculumDetail,Long> {
}
