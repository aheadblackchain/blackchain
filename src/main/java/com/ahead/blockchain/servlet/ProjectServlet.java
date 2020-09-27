package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.ProjectDao;
import com.ahead.blockchain.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author solfeng
 * @date 2020/9/25 17:12
 */
@Service
public class ProjectServlet {
    @Autowired
    private ProjectDao projectDao;
    public Project inserOrUpdate(Project project){
        return projectDao.save(project);
    }
    public void deById(Long id){
        projectDao.deleteById(id);
    }
    public List<Project> projectList(){
        return projectDao.findAll();
    }
    public Project getProjectById(Long id){
        return projectDao.findById(id).orElseGet(() ->new Project());
    }
    public List<Project> findAll(){
        return projectDao.findAll();
    }

}
