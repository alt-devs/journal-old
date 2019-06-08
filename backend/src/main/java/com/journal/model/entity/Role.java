package com.journal.model.entity;

import com.journal.model.enums.RoleName;
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
    @GraphQLQuery(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    @GraphQLQuery(name = "name")
    private RoleName name;


    public Role() {

    }


    public Role(RoleName name) {this.name = name;}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public RoleName getName() {return name;}
    public void setName(RoleName name) {this.name = name;}
}
