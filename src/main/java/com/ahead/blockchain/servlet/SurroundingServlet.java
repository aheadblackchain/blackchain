package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.SurroundingDao;
import com.ahead.blockchain.entity.Surrounding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurroundingServlet {
    @Autowired
    private SurroundingDao surroundingDao;

    public Surrounding insertOrUpdate(Surrounding surrounding){
        return surroundingDao.save(surrounding);
    }

    public void delById(Long id){
        surroundingDao.deleteById(id);
    }

    public List<Surrounding> surroundingList(){
        return surroundingDao.findAll();
    }

    public Surrounding getSurroundingById(Long id){
        return surroundingDao.findById(id).orElseGet(() -> new Surrounding());
    }
}
