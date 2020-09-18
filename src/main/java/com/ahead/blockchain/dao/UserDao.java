package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    List<User> findAllByOrderByIdDesc();
}
