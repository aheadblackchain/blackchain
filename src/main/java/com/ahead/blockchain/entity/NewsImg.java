package com.ahead.blockchain.entity;

import javax.persistence.*;

@Entity
@Table(name = "tab_news_img")
public class NewsImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "news_img")
    private String newsImg;

    @Column(name = "news_id")
    private Long newsId;

    public NewsImg(){

    }

    public NewsImg(Long newsId){
        this.newsId = newsId;
    }

    public NewsImg(String newsImg, Long newsId){
        this.newsImg = newsImg;
        this.newsId = newsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }
}
