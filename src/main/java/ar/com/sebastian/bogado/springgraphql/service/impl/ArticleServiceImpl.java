package ar.com.sebastian.bogado.springgraphql.service.impl;

import ar.com.sebastian.bogado.springgraphql.model.Article;
import ar.com.sebastian.bogado.springgraphql.repository.ArticleRepository;
import ar.com.sebastian.bogado.springgraphql.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAllUserArticles(List<String> articleIds) {
        return articleRepository.findAllByIdIn(articleIds);
    }
}
