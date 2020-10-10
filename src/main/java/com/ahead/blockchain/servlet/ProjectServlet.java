package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.ProjectDao;
import com.ahead.blockchain.dao.ProjectDetailDao;
import com.ahead.blockchain.dao.ProjectImgDao;
import com.ahead.blockchain.entity.Project;
import com.ahead.blockchain.entity.ProjectDetail;
import com.ahead.blockchain.entity.ProjectImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author solfeng
 * @date 2020/9/25 17:12
 */
@Service
public class ProjectServlet {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectDetailDao projectDetailDao;
    @Autowired
    private ProjectImgDao projectImgDao;

    public Project insertOrUpdate(Project project){
        Project projectSave = projectDao.save(project);
        projectDetailDao.deleteInBatch(findDetailByProjectId(projectSave.getId()));
        projectImgDao.deleteInBatch(findImgByProjectId(projectSave.getId()));
        if(project.getDetailList() != null){
            projectDetailDao.saveAll(project.getDetailList().stream().filter(i -> !i.equals("")).map(i -> new ProjectDetail(i, projectSave.getId())).collect(Collectors.toList()));
        }
        if(project.getImgList() != null){
            projectImgDao.saveAll(project.getImgList().stream().map(i -> new ProjectImg(i, projectSave.getId())).collect(Collectors.toList()));
        }
        return projectSave;
    }
    public void deById(Long id){
        projectDetailDao.deleteInBatch(findDetailByProjectId(id));
        projectImgDao.deleteInBatch(findImgByProjectId(id));
        projectDao.deleteById(id);
    }

    public Project getProjectById(Long id){
        Project project = projectDao.findById(id).orElseGet(() ->new Project());
        project.setDetailList(projectDetailDao.findAll(Example.of(new ProjectDetail(project.getId()))).stream().map(ProjectDetail::getDetail).collect(Collectors.toList()));
        project.setImgList(projectImgDao.findAll(Example.of(new ProjectImg(project.getId()))).stream().map(ProjectImg::getProjectImg).collect(Collectors.toList()));
        return  project;
    }
    public List<Project> findAll(){
        List<Project> list = projectDao.findAll();
        list.forEach(i -> {
            List<ProjectImg> images = findImgByProjectId(i.getId());
            i.setProImg(images.size() != 0 ? images.get(0).getProjectImg() : "");
            List<ProjectDetail> details = findDetailByProjectId(i.getId());
            i.setDescription(details.size() != 0 ? details.get(0).getDetail() : "");
        });
        return list;
    }

    private List<ProjectDetail> findDetailByProjectId(Long id){
        return projectDetailDao.findAll(Example.of(new ProjectDetail(id)));
    }
    private List<ProjectImg> findImgByProjectId(Long id){
        return projectImgDao.findAll(Example.of(new ProjectImg(id)));
    }

}
