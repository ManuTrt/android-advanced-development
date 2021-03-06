package com.manu.data.features.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface ArticlesDao {
    @Query("SELECT * FROM articles")
    Single<List<ArticleEntity>> queryArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity todo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticles(List<ArticleEntity> articles);
}
