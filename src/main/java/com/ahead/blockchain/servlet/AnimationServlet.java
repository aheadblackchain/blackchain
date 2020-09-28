package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.AnimationDao;
import com.ahead.blockchain.entity.Animation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimationServlet {
    @Autowired
    private AnimationDao animationDao;

    public Animation insertOrUpdate(Animation animation){
        return animationDao.save(animation);
    }

    public void delById(Long id){
        animationDao.deleteById(id);
    }

    public List<Animation> animationList(){
        return animationDao.findAll();
    }

    public Animation getAnimationById(Long id){
        return animationDao.findById(id).orElseGet(() -> new Animation());
    }

    public List<Animation> findAll(){return animationDao.findAll();}
}
