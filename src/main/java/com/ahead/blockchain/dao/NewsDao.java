package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsDao extends JpaRepository<News, Long> {
    @Query(nativeQuery = true, value = "select * from tab_news limit 0,5")
    public List<News> findNewsLimit();
}
