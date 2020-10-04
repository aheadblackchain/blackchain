package com.ahead.blockchain.entity;

import javax.persistence.*;

@Entity
@Table(name = "tab_news_detail")
public class NewsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "news_detail")
    private String newsDetail;

    @Column(name = "news_id")
    private Long newsId;

    public NewsDetail(){

    }

    public NewsDetail(Long newsId){
        this.newsId = newsId;
    }

    public NewsDetail(String newsDetail, Long newsId){
        this.newsDetail = newsDetail;
        this.newsId = newsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }
}