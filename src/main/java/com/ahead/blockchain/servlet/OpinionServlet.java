package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.OpinionDao;
import com.ahead.blockchain.entity.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionServlet {
    @Autowired
    private OpinionDao opinionDao;

    public Opinion saveOpinion(Opinion opinion){
        return opinionDao.save(opinion);
    }

    public List<Opinion> findAllOrderById(){
        return opinionDao.findAllByOrderByIdDesc();
    }

    public Opinion getOpinion(Long id){
        return opinionDao.findById(id).orElseGet(() -> new Opinion());
    }

}
