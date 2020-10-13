package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionDao extends JpaRepository<Opinion, Long> {

    List<Opinion> findAllByOrderByIdDesc();
}
