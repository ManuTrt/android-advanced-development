package com.manu.newsreader.ui.main.model;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.manu.data.NewsRepository;
import com.manu.newsreader.ui.main.model.mapper.ArticleMapper;
import com.manu.newsreader.ui.main.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver {
    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;

    public final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;

    public NewsListViewModel(@NonNull Application application, NewsRepository repo) {
        super(application);

        this.repo = repo;
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        Log.d("REFRESH_ARTICLES", "just refreshed the articles");
        repo.getNewsArticles()
                .map(new ArticleMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articleVMs) {
        Log.d("RECEIVED_ARTICLES", "just received the articles");
        this.newsList.addAll(articleVMs);
    }

    private void onNewsArticlesError(Throwable throwable) {
        Log.d("ERROR_ARTICLES", "just received an error");
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }
}
