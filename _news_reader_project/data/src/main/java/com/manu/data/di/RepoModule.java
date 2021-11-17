package com.manu.data.di;

import android.app.Application;
import android.content.Context;

import com.manu.data.NewsRepository;
import com.manu.data.features.news.NewsRepositoryImpl;
import com.manu.data.features.news.remote.NewsRemoteSource;
import com.manu.data.remote.HttpClientFactory;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;
    @NonNull
    private final HttpClientFactory httpClientFactory;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
}
