package com.manu.newsreader.feature.newslist.model.mapper;

import com.manu.data.features.news.model.Article;
import com.manu.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.functions.Function;

public class ArticleMapper implements Function<List<Article>, List<ArticleItemViewModel>> {
    @Override
    public List<ArticleItemViewModel> apply(List<Article> articles) {
        List<ArticleItemViewModel> articleVms = new ArrayList<>();

        for (Article article : articles) {
            ArticleItemViewModel articleVM = new ArticleItemViewModel(article.imageUrl, article.title, article.content);

            articleVms.add(articleVM);
        }

        return articleVms;
    }
}
