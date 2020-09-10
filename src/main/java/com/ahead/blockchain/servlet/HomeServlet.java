package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.HomeDao;
import com.ahead.blockchain.entity.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServlet {
    @Autowired
    private HomeDao homeDao;

    public Home insertHome(Home home){
        return homeDao.save(home);
    }

    public List<Home> findAll(){
        return homeDao.findAll();
    }
}
