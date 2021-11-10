package com.manu.newsreader.ui.main;

import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel extends ViewModel {
    public String imagePath;
    public String title;
    public String content;

    public ArticleItemViewModel() {

    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
