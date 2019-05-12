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
@Table(name = "journal.client")
public class Client implements Serializable {

    private static final long serialVersionUID = -1157918411002892624L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "client_seq_gen")
    @SequenceGenerator(name = "client_seq_gen", sequenceName = "journal.client_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "id_company", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Company company;

    @Column(name = "surname")
    @Size(max = 30)
    private String surname;

    @Column(name = "name")
    @Size(max = 30)
    private String name;

    @Column(name = "patronymic")
    @Size(max = 30)
    private String patronymic;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private int gender;

    @Column(name = "phone")
    @Size(max = 12)
    private String phone;

    @Column(name = "email")
    @Size(max = 40)
    private String email;


    public Client() {
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 27 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Client other = (Client) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() 
    {
        return this.surname;
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}

    public Company getCompany() {return company;}
    public void setCompany(Company company) {this.company = company;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPatronymic() {return patronymic;}
    public void setPatronymic(String patronymic) {this.patronymic = patronymic;}

    public Date getBirthDate() {return birthDate;}
    public void setBirthDate(Date birthDate) {this.birthDate = birthDate;}

    public int getGender() {return gender;}
    public void setGender(int gender) {this.gender = gender;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}