package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.Curriculum;
import com.ahead.blockchain.servlet.CurriculumServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author solfeng
 * @date 2020/9/25 11:05
 */
@Controller
public class CurriculumController {
    @Autowired
    private CurriculumServlet curriculumServlet;

    @GetMapping("/curriculumList")
    public String curriculumLsit(Model model) {
        model.addAttribute("curriculumList1", curriculumServlet.curriculumList());
        return "back/curriculumlist";
    }

    @PostMapping("/getCurriculumById/{id}")
    @ResponseBody
    public Curriculum getCurriculumById(@PathVariable("id") Long id) {
        return curriculumServlet.getCurriculumById(id);
    }

    @PostMapping("/saveCurriculum")
    public String saveCurriculum(Curriculum curriculum) {
        curriculumServlet.insertOrUpdate(curriculum);
        return "redirect:/curriculumList";
    }

    @GetMapping("/delCurriculum/{id}")
    public String delCurriculum(@PathVariable("id") Long id) {
        curriculumServlet.delById(id);
        return "redirect:/curriculumList";
    }



    @GetMapping("/curriculumInfo/{id}")
    public String curriculumInfo(Model model,@PathVariable("id") Long id) {
        model.addAttribute("info", curriculumServlet.getCurriculumById(id));
        model.addAttribute("list", curriculumServlet.findCurriculumLimit());
        return "website/curriculuminfo";
    }

}
