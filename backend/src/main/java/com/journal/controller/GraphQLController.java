package com.journal.controller;

import com.journal.service.AuthService;
import com.journal.service.CurrencyService;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Evgeniy Ukhanov
 */


@RestController
public class GraphQLController {

    private final GraphQL graphQL;


    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
//    public Map<String, Object> graphql(@RequestBody Map<String, String> request, HttpServletRequest raw) {
    public Map<String, Object> graphql(@RequestBody Map<String, Object> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query").toString())
//                .query(request.get("query"))
                .operationName(request.get("operationName") != null ? request.get("operationName").toString() : null)
//                .operationName(request.get("operationName"))
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }


    public GraphQLController(CurrencyService currencyService, AuthService authService) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withResolverBuilders(
                        //Resolve by annotations
                        new AnnotatedResolverBuilder())
                .withOperationsFromSingleton(currencyService, CurrencyService.class)
                .withOperationsFromSingleton(authService, AuthService.class)
                .withValueMapperFactory(new JacksonValueMapperFactory())
                .generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }

}