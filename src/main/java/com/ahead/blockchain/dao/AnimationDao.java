package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Animation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimationDao extends JpaRepository<Animation, Long> {
}
