package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author solfeng
 * @date 2020/9/25 10:41
 */
public interface CurriculumDao extends JpaRepository<Curriculum,Long> {
    @Query(nativeQuery = true, value = "select * from tab_curriculum limit 0,5")
    public List<Curriculum> findCurriculumLimit();
}
