package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.DomainDao;
import com.ahead.blockchain.entity.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServlet {
    @Autowired
    private DomainDao domainDao;

    public Domain insertOrUpdate(Domain domain){
        return domainDao.save(domain);
    }

    public void delById(Long id){
        domainDao.deleteById(id);
    }

    public List<Domain> domainList(){
        return domainDao.findAll();
    }

    public Domain getDomainById(Long id){
        return domainDao.findById(id).orElseGet(() -> new Domain());
    }
}
