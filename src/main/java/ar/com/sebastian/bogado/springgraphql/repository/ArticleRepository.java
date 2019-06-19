package ar.com.sebastian.bogado.springgraphql.repository;

import ar.com.sebastian.bogado.springgraphql.model.Article;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, ObjectId> {

    List<Article> findAllByIdIn(List<String> ids);

}
