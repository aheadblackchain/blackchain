package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.TestDao;
import com.ahead.blockchain.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServlet {
    @Autowired
    TestDao testDao;
    public  void save(Test test){
        testDao.save(test);
    }

    public List<Test> findAll(){
       return testDao.findAll();
    }
}
