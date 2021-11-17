package com.manu.newsreader.ui.main.view.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manu.newsreader.ui.main.adapter.ArticleAdapter;
import com.manu.newsreader.ui.main.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {

    @BindingAdapter({"items"})
    public static void addArticleItems(RecyclerView recyclerView, List<ArticleItemViewModel> articles) {
        ArticleAdapter articleAdapter = (ArticleAdapter) recyclerView.getAdapter();

        if (articleAdapter == null) {
            articleAdapter = new ArticleAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(articleAdapter);
        }

        articleAdapter.setArticleModelList(articles);
    }
}
