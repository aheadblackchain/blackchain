package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsDao extends JpaRepository<News, Long> {
    @Query(nativeQuery = true, value = "select * from tab_news limit 0,5")
    public List<News> findNewsLimit();

    @Modifying
    @Query(nativeQuery = true, value = "update tab_news a set a.read_num = a.read_num + 1 where a.id = :id")
    public void updateReadNum(@Param("id") Long id);
}
