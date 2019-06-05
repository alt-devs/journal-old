package com.journal.model.entity;

import com.journal.audit.DateAudit;
import io.leangen.graphql.annotations.GraphQLQuery;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @NotNull
    @GraphQLQuery(name = "id")
    private Long id;

//    @NotBlank
    @Size(max = 40)
    @GraphQLQuery(name = "name")
    private String name;

//    @NotBlank
    @Size(max = 15)
    @GraphQLQuery(name = "username")
    private String username;

//    @NaturalId
//    @NotBlank
    @Size(max = 40)
//    @Email
    @GraphQLQuery(name = "email")
    private String email;

//    @NotBlank
    @Size(max = 100)
    @GraphQLQuery(name = "password")
    private String password;

    @JoinColumn(name = "id_role", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH} )
    @GraphQLQuery(name = "role")
    private Role role;



//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();


    public User() {
    }


    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

//    public Set<Role> getRoles() {return roles;}
//    public void setRoles(Set<Role> roles) {this.roles = roles;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}
}