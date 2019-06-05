package com.journal.model.service;


import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

@Component
public class LoginResponse {

    @GraphQLQuery(name = "accessToken")
    private String accessToken;

    @GraphQLQuery(name = "tokenType")
    private String tokenType;


    public LoginResponse() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginResponse that = (LoginResponse) o;

        return !(accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null);

    }

    @Override
    public int hashCode() {
        return accessToken != null ? accessToken.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "LoginResponse{" +
                "accessToken='" + accessToken + '\'' +
                '}';
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
