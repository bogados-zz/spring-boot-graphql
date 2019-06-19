package ar.com.sebastian.bogado.springgraphql.graphql.datafetcher;

import ar.com.sebastian.bogado.springgraphql.model.User;
import ar.com.sebastian.bogado.springgraphql.service.UserService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllUsersDataFetcher implements GraphQLQueryResolver {

    private final UserService userService;

    @Autowired
    AllUsersDataFetcher(UserService userService) {
        this.userService = userService;
    }

    public List<User> getUsers(DataFetchingEnvironment env) {
        User user = env.getSource();
        List<User> friends;
        if (user != null) {
            friends = userService.findByIdIn(user.getFriendsIds());
        } else {
            friends = userService.findAll();
        }
        return friends;
    }

    public User getUser(String id) {
        return this.userService.findById(new ObjectId(id)).orElseThrow(RuntimeException::new);
    }

}
