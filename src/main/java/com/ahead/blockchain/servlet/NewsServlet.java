package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.NewsDao;
import com.ahead.blockchain.dao.NewsDetailDao;
import com.ahead.blockchain.dao.NewsImgDao;
import com.ahead.blockchain.entity.News;
import com.ahead.blockchain.entity.NewsDetail;
import com.ahead.blockchain.entity.NewsImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        newsDetailDao.deleteInBatch(findDetailByNewId(insertNews.getId()));
        newsImgDao.deleteInBatch(findImgByNewId(insertNews.getId()));
        if(news.getDetailList() != null){
            newsDetailDao.saveAll(news.getDetailList().stream().filter(i -> !i.equals("")).map(i -> new NewsDetail(i, insertNews.getId())).collect(Collectors.toList()));
        }
        if(news.getImgList() != null){
            newsImgDao.saveAll(news.getImgList().stream().map(i -> new NewsImg(i, insertNews.getId())).collect(Collectors.toList()));
        }
        return insertNews;
    }

    public void delById(Long id){
        newsDetailDao.deleteInBatch(findDetailByNewId(id));
        newsImgDao.deleteInBatch(findImgByNewId(id));
        newsDao.deleteById(id);
    }

    public List<News> newsList(){
        return newsDao.findAll();
    }

    public News getNewsById(Long id){
        News news = newsDao.findById(id).orElseGet(News::new);
        Example<NewsDetail> exampleDetail = Example.of(new NewsDetail(news.getId()));
        news.setDetailList(newsDetailDao.findAll(exampleDetail).stream().map(NewsDetail::getNewsDetail).collect(Collectors.toList()));
        Example<NewsImg> exampleImg = Example.of(new NewsImg(news.getId()));
        news.setImgList(newsImgDao.findAll(exampleImg).stream().map(NewsImg::getNewsImg).collect(Collectors.toList()));
        return news;
    }

    private List<NewsDetail> findDetailByNewId(Long id){
        return newsDetailDao.findAll(Example.of(new NewsDetail(id)));
    }
    private List<NewsImg> findImgByNewId(Long id){
        return newsImgDao.findAll(Example.of(new NewsImg(id)));
    }
}
