package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.News;
import com.ahead.blockchain.servlet.NewsServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsServlet newsServlet;

    @GetMapping("/list")
    public String newsList(Model model) {
        model.addAttribute("newsList", newsServlet.newsList());
        return "back/newslist";
    }

    @PostMapping("/byId/{id}")
    @ResponseBody
    public News getNewsById(@PathVariable("id") Long id) {
        return newsServlet.getNewsById(id);
    }

    @PostMapping("/save")
    public String saveNews(News news) {
        newsServlet.insertOrUpdate(news);
        return "redirect:/news/list";
    }

    @GetMapping("/del/{id}")
    public String delNews(@PathVariable("id") Long id) {
        newsServlet.delById(id);
        return "redirect:/news/list";
    }

    @GetMapping("/newInfo/{id}")
    public String newInfo(HttpServletRequest request, Model model, @PathVariable("id") Long id) {
        HttpSession session = request.getSession();
        Set<String> readSession = (Set<String>) session.getServletContext().getAttribute("readNum");
        if(readSession != null && !readSession.contains(session.getId())){
            readSession.add(session.getId());
            newsServlet.updateReadNum(id);
        }
        model.addAttribute("news" , newsServlet.getNewsById(id));
        model.addAttribute("newsList", newsServlet.findNewsList());
        return "website/newinfo";
    }

}
