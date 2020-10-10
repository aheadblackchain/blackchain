package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.CurriculumDao;
import com.ahead.blockchain.dao.CurriculumDetailDao;
import com.ahead.blockchain.dao.CurriculumImgDao;
import com.ahead.blockchain.entity.Curriculum;
import com.ahead.blockchain.entity.CurriculumDetail;
import com.ahead.blockchain.entity.CurriculumImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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


    public Curriculum insertOrUpdate(Curriculum curriculum) {
        Curriculum CurriculumInfo = curriculumDao.save(curriculum);
        curriculumDetailDao.deleteInBatch(findDetailByCurId(CurriculumInfo.getId()));
        curriculumImgDao.deleteInBatch(findImgByCurId(CurriculumInfo.getId()));
        if (curriculum.getDetailList() != null) {
            curriculumDetailDao.saveAll(curriculum.getDetailList().stream().map(i -> new CurriculumDetail(i, CurriculumInfo.getId())).collect(Collectors.toList()));
        }
        if (curriculum.getImgList() != null) {
            curriculumImgDao.saveAll(curriculum.getImgList().stream().map(i -> new CurriculumImg(i, CurriculumInfo.getId())).collect(Collectors.toList()));
        }

        return CurriculumInfo;
    }

    public void delById(Long id) {
        curriculumDetailDao.deleteInBatch(findDetailByCurId(id));
        curriculumImgDao.deleteInBatch(findImgByCurId(id));
        curriculumDao.deleteById(id);
    }

    public List<Curriculum> curriculumList() {
        List<Curriculum> curriculumList = curriculumDao.findAll();
        return setImgAndDetail(curriculumList);
    }

    public Curriculum getCurriculumById(Long id) {
        Curriculum curriculums = curriculumDao.findById(id).orElseGet(Curriculum::new);
        Example<CurriculumDetail> exampleDetail =Example.of(new CurriculumDetail(curriculums.getId()));
        curriculums.setDetailList(curriculumDetailDao.findAll(exampleDetail).stream().map(CurriculumDetail::getCurrDatail).collect(Collectors.toList()));
        Example<CurriculumImg> exampleImg =Example.of(new CurriculumImg(curriculums.getId()));
        curriculums.setImgList(curriculumImgDao.findAll(exampleImg).stream().map(CurriculumImg::getCurImg).collect(Collectors.toList()));
        return curriculums;
    }

    public List<Curriculum> findCurriculumLimit() {
        List<Curriculum> list = curriculumDao.findCurriculumLimit();
        return setImgAndDetail(list);
    }

    private List<CurriculumDetail> findDetailByCurId(Long id){
        return curriculumDetailDao.findAll(Example.of(new CurriculumDetail(id)));
    }
    private List<CurriculumImg> findImgByCurId(Long id){
        return curriculumImgDao.findAll(Example.of(new CurriculumImg(id)));
    }

    public List<Curriculum> setImgAndDetail(List<Curriculum> list){
        list.forEach(i -> {
            List<CurriculumImg> curriculumImgList = findImgByCurId(i.getId());
            i.setCurriculumImage(curriculumImgList.size() == 0 ? "" : curriculumImgList.get(0).getCurImg());
        });
        return list;
    }
}
