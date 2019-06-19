package ar.com.sebastian.bogado.springgraphql.graphql.datafetcher;

import ar.com.sebastian.bogado.springgraphql.model.Article;
import ar.com.sebastian.bogado.springgraphql.model.User;
import ar.com.sebastian.bogado.springgraphql.service.ArticleService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticlesDataFetcher implements GraphQLQueryResolver {

    private final ArticleService articleService;

    @Autowired
    ArticlesDataFetcher(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<Article> getArticle(DataFetchingEnvironment env) {
        User user = env.getSource();
        List<String> articleIds = new ArrayList<>();
        if (user != null) {
            articleIds = user.getArticlesIds();
        }
        List<Article> articles = articleService.findAllUserArticles(articleIds);
        return articles;
    }
}