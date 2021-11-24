package com.manu.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.manu.data.NewsRepository;
import com.manu.data.features.news.NewsRepositoryImpl;
import com.manu.data.features.news.local.NewsLocalSource;
import com.manu.data.features.news.remote.NewsRemoteSource;
import com.manu.data.remote.HttpClientFactory;
import com.manu.data.store.local.ArticleDatabase;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private final Context context;
    @NonNull
    private final HttpClientFactory httpClientFactory;

    private volatile ArticleDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideNewsLocalSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    private NewsLocalSource provideNewsLocalSource() {
        ArticleDatabase database = getInstance();
        return new NewsLocalSource(database.articlesDao());
    }

    ArticleDatabase getInstance() {
        if (database == null) {
            synchronized (ArticleDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context,
                            ArticleDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return database;
    }
}
