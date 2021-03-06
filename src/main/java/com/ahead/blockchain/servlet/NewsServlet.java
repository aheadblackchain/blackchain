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

import javax.transaction.Transactional;
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
        List<News> news = newsDao.findAll();
        news.forEach(i -> {
            List<NewsImg> images = findImgByNewId(i.getId());
            i.setNewImg(images.size() != 0 ? images.get(0).getNewsImg() : "");
            List<NewsDetail> details = findDetailByNewId(i.getId());
            i.setDetail(details.size() != 0 ? details.get(0).getNewsDetail() : "");
        });
        return news;
    }

    public News getNewsById(Long id){
        News news = newsDao.findById(id).orElseGet(News::new);
        news.setDetailList(newsDetailDao.findAll(Example.of(new NewsDetail(news.getId()))).stream().map(NewsDetail::getNewsDetail).collect(Collectors.toList()));
        news.setImgList(newsImgDao.findAll(Example.of(new NewsImg(news.getId()))).stream().map(NewsImg::getNewsImg).collect(Collectors.toList()));
        return news;
    }

    @Transactional
    public void updateReadNum(Long id){
        newsDao.updateReadNum(id);
    }

    public List<News> findNewsList(){
        return newsDao.findNewsLimit();
    }

    private List<NewsDetail> findDetailByNewId(Long id){
        return newsDetailDao.findAll(Example.of(new NewsDetail(id)));
    }
    private List<NewsImg> findImgByNewId(Long id){
        return newsImgDao.findAll(Example.of(new NewsImg(id)));
    }
}
