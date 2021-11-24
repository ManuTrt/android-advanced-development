package com.manu.data.features.news.local;

import android.util.Log;

import com.manu.data.features.news.model.Article;
import com.manu.data.features.news.model.mapper.ArticleEntityToModelMapper;
import com.manu.data.features.news.model.mapper.ArticleModelToEntityMapper;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalSource {

    private final ArticlesDao dao;

    public NewsLocalSource(ArticlesDao dao) {
        this.dao = dao;
    }

    public Single<List<Article>> getArticles() {
        Log.d("GET_ARTICLES_LOCAL", "just got the articles");
        return dao.queryArticles().map(new ArticleEntityToModelMapper()::map);
    }

    public Completable saveArticle(ArticleEntity article) {
        return dao.insertArticle(article);
    }

    public void saveArticles(List<Article> articles) {
        Log.d("SAVE_ARTICLES_LOCAL", "just saved the articles");
        dao.insertArticles(new ArticleModelToEntityMapper().map(articles))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
