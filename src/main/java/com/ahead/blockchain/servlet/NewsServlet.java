package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.NewsDao;
import com.ahead.blockchain.dao.NewsDetailDao;
import com.ahead.blockchain.dao.NewsImgDao;
import com.ahead.blockchain.entity.News;
import com.ahead.blockchain.entity.NewsDetail;
import com.ahead.blockchain.entity.NewsImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServlet {
    @Autowired
    private NewsDao newsDao;
    @Autowired
    private NewsDetailDao newsDetailDao;
    @Autowired
    private NewsImgDao newsImgDao;


    public News insertOrUpdate(News news){
        News insertNews = newsDao.save(news);
        if(news.getDetailList() != null){
            newsDetailDao.saveAll(news.getDetailList().stream().map(i -> new NewsDetail(i, insertNews.getId())).collect(Collectors.toList()));
        }
        if(news.getImgList() != null){
            newsImgDao.saveAll(news.getImgList().stream().map(i -> new NewsImg(i, insertNews.getId())).collect(Collectors.toList()));
        }
        return insertNews;
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
