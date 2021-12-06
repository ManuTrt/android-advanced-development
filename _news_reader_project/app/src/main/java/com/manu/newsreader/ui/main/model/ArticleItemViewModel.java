package com.manu.newsreader.ui.main.model;

import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel extends ViewModel {
    public final String imagePath;
    public final String title;
    public final String content;

    public ArticleItemViewModel(String imagePath, String title, String content) {
        this.imagePath = imagePath;
        this.title = title;
        this.content = content;
    }
}
