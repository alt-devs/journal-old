package com.journal.model.service;

import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Evgeniy Ukhanov
 */


@Component
public class LoginResponse {

    @GraphQLQuery(name = "accessToken")
    private String accessToken;

    @GraphQLQuery(name = "tokenType")
    private String tokenType;


    public LoginResponse() {
    }


    @Override
    public int hashCode() {
        int hash = 6;
        hash = 15 * hash + Objects.hashCode(this.tokenType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final LoginResponse other = (LoginResponse) obj;
        return Objects.equals(this.tokenType, other.tokenType);
    }

    @Override
    public String toString()
    {
        return this.tokenType;
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
