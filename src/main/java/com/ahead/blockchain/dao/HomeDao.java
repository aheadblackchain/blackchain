package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeDao extends JpaRepository<Home, Long> {

}
