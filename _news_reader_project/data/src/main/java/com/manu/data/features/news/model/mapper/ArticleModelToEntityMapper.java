package com.manu.data.features.news.model.mapper;

import com.manu.data.Mapper;
import com.manu.data.features.news.local.ArticleEntity;
import com.manu.data.features.news.model.Article;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleModelToEntityMapper implements Mapper<List<Article>, List<ArticleEntity>> {

    @Override
    public List<ArticleEntity> map(List<Article> articles) {
        return articles.stream()
                .map(article -> new ArticleEntity(article.imageUrl, article.title, article.content, article.description))
                .collect(Collectors.toList());
    }
}
