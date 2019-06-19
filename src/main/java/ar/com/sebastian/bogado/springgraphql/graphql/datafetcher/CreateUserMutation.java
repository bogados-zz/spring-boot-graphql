package ar.com.sebastian.bogado.springgraphql.graphql.datafetcher;

import ar.com.sebastian.bogado.springgraphql.graphql.input.CreateUserInput;
import ar.com.sebastian.bogado.springgraphql.model.User;
import ar.com.sebastian.bogado.springgraphql.service.UserService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserMutation implements GraphQLMutationResolver {

    private final UserService userService;
    private final MapperFacade orikaMapper;

    @Autowired
    public CreateUserMutation(UserService userService, MapperFacade orikaMapper) {
        this.userService = userService;
        this.orikaMapper = orikaMapper;
    }

    public User createUser(CreateUserInput createUserInput) {
        return userService.createUser(orikaMapper.map(createUserInput, User.class));
    }

}
