package com.manu.newsreader.ui.main.model;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.manu.data.NewsRepository;
import com.manu.data.features.news.model.Article;
import com.manu.newsreader.R;
import com.manu.newsreader.ui.main.model.mapper.ArticleMapper;
import com.manu.newsreader.ui.main.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver {
    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;

    public final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();;

    public NewsListViewModel(@NonNull Application application, NewsRepository repo) {
        super(application);

        this.repo = repo;
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        repo.getNewsArticles()
                .map(new ArticleMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articleVMs) {

        this.newsList.addAll(articleVMs);
    }

    private void onNewsArticlesError(Throwable throwable) {
    }

    public void onPoweredBySelected() {
    }
}
