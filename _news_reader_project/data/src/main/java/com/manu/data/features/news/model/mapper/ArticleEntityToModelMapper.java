package com.manu.data.features.news.model.mapper;

import com.manu.data.Mapper;
import com.manu.data.features.news.local.ArticleEntity;
import com.manu.data.features.news.model.Article;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleEntityToModelMapper implements Mapper<List<ArticleEntity>, List<Article>> {
    @Override
    public List<Article> map(List<ArticleEntity> articleEntities) {
        return articleEntities.stream()
                .map(ae -> new Article(ae.imageUrl, ae.title, ae.content, ae.description))
                .collect(Collectors.toList());
    }
}
