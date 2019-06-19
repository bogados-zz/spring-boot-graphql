package ar.com.sebastian.bogado.springgraphql.service;

import ar.com.sebastian.bogado.springgraphql.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAllUserArticles(List<String> articleIds);
}
