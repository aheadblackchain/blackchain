package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<Test,Long> {
}
