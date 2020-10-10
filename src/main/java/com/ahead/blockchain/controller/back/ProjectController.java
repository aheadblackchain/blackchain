package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.Project;
import com.ahead.blockchain.servlet.ProjectServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author solfeng
 * @date 2020/9/25 17:26
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectServlet projectServlet;

    @GetMapping("/list")
    public String projectList(Model model) {
        model.addAttribute("projectList1", projectServlet.findAll());
        return "back/projectlist";
    }

    @PostMapping("/byId/{id}")
    @ResponseBody
    public Project getProjectById(@PathVariable("id") Long id) {
        return projectServlet.getProjectById(id);
    }

    @PostMapping("/save")
    public String saveCurriculum(Project project) {
        projectServlet.insertOrUpdate(project);
        return "redirect:/project/list";
    }

    @GetMapping("/del/{id}")
    public String delProject(@PathVariable("id") Long id) {
        projectServlet.deById(id);
        return "redirect:/project/list";
    }

    @GetMapping("/info/{id}")
    public String projectInfo(Model model, @PathVariable("id") Long id) {
        model.addAttribute("info", projectServlet.getProjectById(id));
        return "website/projectinfo";
    }
}
