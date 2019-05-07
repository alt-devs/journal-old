package journal.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author Evgeniy Ukhanov
 */


@Entity
@Table(name = "journal.user")
public class User implements Serializable {

    private static final long serialVersionUID = -6767952602075264055L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "journal.user_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

//    @JoinColumn(name = "id_employee", referencedColumnName = "id")
//    @OneToOne(fetch = FetchType.LAZY)
//    private Employee employee;

    @JoinColumn(name = "id_role", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Role role;

    @Column(name = "user_name")
    @Size(max = 50)
    private String userName;

    @Column(name = "password")
    @Size(max = 32)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date_time")
    private Date createDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_active")
    private Date lastActive;


    public User() {
    }


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }


    @Override
    public String toString() 
    {
        return this.userName;
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Date getCreateDateTime() {return createDateTime;}
    public void setCreateDateTime(Date createDateTime) {this.createDateTime = createDateTime;}

    public Date getLastActive() {return lastActive;}
    public void setLastActive(Date lastActive) {this.lastActive = lastActive;}
}