package com.journal.model.entity;

import com.journal.model.enums.RoleName;
import io.leangen.graphql.annotations.GraphQLQuery;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_seq_gen")
    @SequenceGenerator(name = "roles_seq_gen", sequenceName = "roles_id_seq", allocationSize = 1)
    @NotNull
    @GraphQLQuery(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
//    @NaturalId
    @Column(length = 30)
    @GraphQLQuery(name = "name")
    private RoleName name;


    public Role() {

    }


    public Role(RoleName name) {this.name = name;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public RoleName getName() {return name;}
    public void setName(RoleName name) {this.name = name;}
}
