package ar.com.sebastian.bogado.springgraphql.service;

import ar.com.sebastian.bogado.springgraphql.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(String id);

    List<User> findByIdIn(List<String> friendsIds);

    List<User> findAll();

    Optional<User> findById(ObjectId id);
}
