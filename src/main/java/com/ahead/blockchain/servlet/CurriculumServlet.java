package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.CurriculumDao;
import com.ahead.blockchain.entity.Curriculum;
import com.ahead.blockchain.entity.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author solfeng
 * @date 2020/9/25 10:48
 */
@Service
public class CurriculumServlet {
    @Autowired
    private CurriculumDao curriculumDao;
    public Curriculum inserOrUpdate(Curriculum curriculum){
        return curriculumDao.save(curriculum);
    }
    public void delById(Long id){
        curriculumDao.deleteById(id);
    }
    public List<Curriculum> curriculumList(){
        return curriculumDao.findAll();
    }
    public Curriculum getCurriculumById(Long id){
        return curriculumDao.findById(id).orElseGet(() -> new Curriculum());
    }
    public List<Curriculum> findAll(){
        return curriculumDao.findAll();
    }
}
