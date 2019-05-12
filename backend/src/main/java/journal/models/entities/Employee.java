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
@Table(name = "journal.employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 7095817138481029042L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_seq_gen")
    @SequenceGenerator(name = "employee_seq_gen", sequenceName = "journal.employee_id_seq", allocationSize = 1)
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

    @Column(name = "phone")
    @Size(max = 12)
    private String phone;

    @Column(name = "position")
    @Size(max = 40)
    private String position;


    public Employee() {
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Employee other = (Employee) obj;
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

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}
}