package com.manu.newsreader.ui.main.model;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.manu.data.NewsRepository;
import com.manu.newsreader.ui.main.model.mapper.ArticleMapper;
import com.manu.newsreader.ui.main.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsListViewModel extends AndroidViewModel implements DefaultLifecycleObserver {
    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;

    public final ObservableList<ArticleItemViewModel> newsList;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;

    public NewsListViewModel(@NonNull Application application, NewsRepository repo) {
        super(application);

        this.newsList = new ObservableArrayList<>();
        this.repo = repo;
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
    }

    @SuppressLint("CheckResult")
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
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
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }
}
