package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Talents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author solfeng
 * @date 2020/9/23 20:05
 */
public interface TalentsDao extends JpaRepository<Talents, Long> {
    List<Talents> findAllByOrderByIdDesc();
}
