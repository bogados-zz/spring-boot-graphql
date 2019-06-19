package ar.com.sebastian.bogado.springgraphql.repository;

import ar.com.sebastian.bogado.springgraphql.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    List<User> findAllByIdIn(List<String> friendsIds);
}
