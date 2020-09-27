package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.TalentsDao;
import com.ahead.blockchain.entity.Talents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author solfeng
 * @date 2020/9/23 20:13
 */
@Service
public class TalentsServlet {
    @Autowired
     TalentsDao talentsDao;

    public Talents inserOrUpdate(Talents talents) {
        return talentsDao.save(talents);
    }
    public void delById(Long id){
        talentsDao.deleteById(id);
    }
    public List<Talents> talentsList(){
        return talentsDao.findAllByOrderByIdDesc();
    }
    public Talents getTalentsById(Long id){
        return talentsDao.findById(id).orElseGet(() -> new Talents());
    }
    public List<Talents> findAll() {
        return talentsDao.findAll();
    }
}
