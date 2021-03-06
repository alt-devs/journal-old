package com.journal.model.entity;

import io.leangen.graphql.annotations.GraphQLQuery;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Evgeniy Ukhanov
 */


@Entity
@Table(name = "role", schema = "admin")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "role_seq_gen")
    @SequenceGenerator(name = "role_seq_gen", sequenceName = "admin.role_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    @GraphQLQuery(name = "id")
    private long id;

    @Column(name = "name", length = 50)
    @GraphQLQuery(name = "name")
    private String name;

    @Column(name = "secure_name", length = 50)
    @GraphQLQuery(name = "secureName")
//    private RoleName secureName;
    private String secureName;


    public Role() {

    }


    //public Role(RoleName name) {this.secureName = secureName;}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getSecureName() {return secureName;}
    public void setSecureName(String secureName) {this.secureName = secureName;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
