package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDao extends JpaRepository<News, Long> {
}
