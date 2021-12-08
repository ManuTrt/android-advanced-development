package com.manu.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.manu.data.features.news.local.ArticleEntity;
import com.manu.data.features.news.local.ArticlesDao;

@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class ArticleDatabase extends RoomDatabase{
    public abstract ArticlesDao articlesDao();
}
