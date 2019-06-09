package com.journal.model.entity;

import com.journal.audit.DateAudit;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

/**
 * @author Evgeniy Ukhanov
 */


@Entity
@Table(name = "user", schema = "admin")
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "admin.user_id_seq", allocationSize = 1)
    @NotNull
    @GraphQLQuery(name = "id")
    private long id;

//    @JoinColumn(name = "id_employee", referencedColumnName = "id")
//    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH} )
//    @GraphQLQuery(name = "role")
//    private Employee employee;

    @JoinColumn(name = "id_role", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH} )
    @GraphQLQuery(name = "role")
    private Role role;

    @Size(max = 50)
    @Column(name = "login")
    @GraphQLQuery(name = "login")
    private String username;

    @Size(max = 100)
//    @Column(name = "password")
    @GraphQLQuery(name = "password")
    private String password;

    @NotNull
    @Column(name = "last_active")
    private Instant lastActive;

    @Transient
    @Size(max = 40)
    @GraphQLQuery(name = "name")
    private String name;

    @Size(max = 50)
//    @Email
//    @Column(name = "email")
    @GraphQLQuery(name = "email")
    private String email;





    public User() {
    }


    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public User(String username, String password) {
//        this.name = name;
        this.username = username;
//        this.email = email;
        this.password = password;
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    public Instant getLastActive() {return lastActive;}
    public void setLastActive(Instant lastActive) {this.lastActive = lastActive;}
}