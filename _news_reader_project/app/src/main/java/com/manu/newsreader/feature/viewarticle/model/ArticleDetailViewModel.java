package com.manu.newsreader.feature.viewarticle.model;

import androidx.lifecycle.ViewModel;

public class ArticleDetailViewModel extends ViewModel {
    private final String imagePath;
    private final String title;
    private final String content;

    public ArticleDetailViewModel(String imagePath, String title, String content) {
        this.imagePath = imagePath;
        this.title = title;
        this.content = content;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
