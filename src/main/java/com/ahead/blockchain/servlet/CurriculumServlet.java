package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.CurriculumDao;
import com.ahead.blockchain.dao.CurriculumDetailDao;
import com.ahead.blockchain.dao.CurriculumImgDao;
import com.ahead.blockchain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author solfeng
 * @date 2020/9/25 10:48
 */
@Service
public class CurriculumServlet {
    @Autowired
    private CurriculumDao curriculumDao;
    @Autowired
    private CurriculumDetailDao curriculumDetailDao;
    @Autowired
    private CurriculumImgDao curriculumImgDao;


    public Curriculum inserOrUpdate(Curriculum curriculum) {
        Curriculum CurriculumInfo = curriculumDao.save(curriculum);
        if (curriculum.getDetaillList() !=null){
             curriculumDetailDao.saveAll(curriculum.getDetaillList().stream().map(i -> new CurriculumDetail(i,CurriculumInfo.getId())).collect(Collectors.toList()));
        }
        if (curriculum.getImgList() !=null){
            curriculumImgDao.saveAll(curriculum.getImgList().stream().map(i -> new CurriculumImg(i,CurriculumInfo.getId())).collect(Collectors.toList()));
        }
        
        return CurriculumInfo;
    }

    public void delById(Long id) {
        curriculumDao.deleteById(id);
    }

    public List<Curriculum> curriculumList() {
        return curriculumDao.findAll();
    }

    public Curriculum getCurriculumById(Long id) {
        return curriculumDao.findById(id).orElseGet(() -> new Curriculum());
    }

    public List<Curriculum> findAll() {
        return curriculumDao.findAll();
    }

}
