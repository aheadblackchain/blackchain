package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.NewsDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDetailDao extends JpaRepository<NewsDetail, Long> {
}
