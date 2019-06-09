package com.journal.model.service;

import io.leangen.graphql.annotations.GraphQLQuery;

import java.util.Objects;

/**
 * @author Evgeniy Ukhanov
 */


public class CredentialInput {

//    @GraphQLQuery(name = "name")
//    private String name;

    @GraphQLQuery(name = "username")
    private String username;

//    @GraphQLQuery(name = "email")
//    private String email;

    @GraphQLQuery(name = "password")
    private String password;


    public CredentialInput() {
    }


    @Override
    public int hashCode() {
        int hash = 6;
        hash = 15 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final CredentialInput other = (CredentialInput) obj;
        return Objects.equals(this.username, other.username);
    }

    @Override
    public String toString()
    {
        return this.username;
    }

//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public String getEmail() {
//        return email;
//    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
