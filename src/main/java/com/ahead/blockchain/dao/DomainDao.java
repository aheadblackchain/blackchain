package com.ahead.blockchain.dao;

import com.ahead.blockchain.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainDao extends JpaRepository<Domain, Long> {
}
