package com.manu.data.features.news.remote;

import com.manu.data.features.news.model.Article;
import com.manu.data.features.news.remote.mapper.NewsDtoToNewsMapper;
import com.manu.data.remote.NewsApi;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {

    private static final String API_KEY = "189888604dc24a92824de0e68829d20a";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(@NonNull NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io())
                .map(new NewsDtoToNewsMapper());
    }

}
