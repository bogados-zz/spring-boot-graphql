package ar.com.sebastian.bogado.springgraphql.service.impl;

import ar.com.sebastian.bogado.springgraphql.model.User;
import ar.com.sebastian.bogado.springgraphql.repository.UserRepository;
import ar.com.sebastian.bogado.springgraphql.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(new ObjectId(id));
    }

    @Override
    public List<User> findByIdIn(List<String> friendsIds) {
        return userRepository.findAllByIdIn(friendsIds);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }
}
