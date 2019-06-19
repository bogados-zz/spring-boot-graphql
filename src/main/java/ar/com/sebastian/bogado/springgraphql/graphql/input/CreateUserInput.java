package ar.com.sebastian.bogado.springgraphql.graphql.input;

import lombok.Data;

@Data
public class CreateUserInput {
    private String name;
    private Integer age;
    private String nationality;
}
