package com.manu.data.features.news.local;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class NewsLocalSource {

    private final ArticlesDao dao;

    public NewsLocalSource(ArticlesDao dao) {
        this.dao = dao;
    }

    public Flowable<List<ArticleEntity>> getArticles() {
        return dao.queryArticles();
    }

    public Completable saveArticle(ArticleEntity article) {
        return dao.insertArticle(article);
    }
}
