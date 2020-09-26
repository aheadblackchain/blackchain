package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.NewsDao;
import com.ahead.blockchain.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServlet {
    @Autowired
    private NewsDao newsDao;

    public News insertOrUpdate(News news){
        return newsDao.save(news);
    }

    public void delById(Long id){
        newsDao.deleteById(id);
    }

    public List<News> newsList(){
        return newsDao.findAll();
    }

    public News getNewsById(Long id){
        return newsDao.findById(id).orElseGet(() -> new News());
    }
}
