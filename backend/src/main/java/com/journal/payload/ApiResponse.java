package com.journal.payload;

import io.leangen.graphql.annotations.GraphQLQuery;

/**
 * @author Evgeniy Ukhanov
 */


public class ApiResponse {
    @GraphQLQuery(name = "success")
    private Boolean success;

    @GraphQLQuery(name = "message")
    private String message;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public Boolean getSuccess() {return success;}
    public void setSuccess(Boolean success) {this.success = success;}

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
}