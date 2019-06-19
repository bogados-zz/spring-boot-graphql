package ar.com.sebastian.bogado.springgraphql.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("article")
@Data
public class Article {
    private ObjectId id;
    private String title;
    private Integer minutesRead;
    private String authorId;
}
