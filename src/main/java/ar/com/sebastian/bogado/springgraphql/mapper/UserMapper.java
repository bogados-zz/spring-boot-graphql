package ar.com.sebastian.bogado.springgraphql.mapper;

import ar.com.sebastian.bogado.springgraphql.graphql.input.CreateUserInput;
import ar.com.sebastian.bogado.springgraphql.model.User;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        registerCreateUserInputToUser(orikaMapperFactory);
    }

    private void registerCreateUserInputToUser(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(User.class, CreateUserInput.class)
                .field("name","name")
                .field("age","age")
                .field("nationality","nationality")
                .byDefault()
                .register();
    }
}
