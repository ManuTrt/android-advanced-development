package com.manu.newsreader.ui.main;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {
    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        ArticleItemViewModel article1 = new ArticleItemViewModel();
        article1.setImagePath("http://via.placeholder.com/300.png");
        article1.setTitle("Lorem Ipsum1");
        article1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        ArticleItemViewModel article2 = new ArticleItemViewModel();
        article2.setImagePath("http://via.placeholder.com/300.png");
        article2.setTitle("Lorem Ipsum2");
        article2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        ArticleItemViewModel article3 = new ArticleItemViewModel();
        article3.setImagePath("http://via.placeholder.com/300.png");
        article3.setTitle("Lorem Ipsum3");
        article3.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        ArticleItemViewModel article4 = new ArticleItemViewModel();
        article4.setImagePath("src/main/res/mipmap-xxxhdpi/ic_launcher.webp");
        article4.setTitle("Lorem Ipsum4");
        article4.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        ArticleItemViewModel article5 = new ArticleItemViewModel();
        article5.setImagePath("src/main/res/mipmap-xxxhdpi/ic_launcher.webp");
        article5.setTitle("Lorem Ipsum5");
        article5.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        newsList.add(article1);
        newsList.add(article2);
        newsList.add(article3);
        newsList.add(article4);
        newsList.add(article5);
    }
}
