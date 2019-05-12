package journal.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Evgeniy Ukhanov
 */


@Entity
@Table(name = "journal.company")
public class Company implements Serializable {

	private static final long serialVersionUID = -7063663198054938091L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "company_seq_gen")
    @SequenceGenerator(name = "company_seq_gen", sequenceName = "journal.company_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "id_currency", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Currency currency;

    @Column(name = "name")
    @Size(max = 100)
    private String name;

    @Column(name = "email")
    @Size(max = 40)
    private String email;

    @Column(name = "photo_path")
    @Size(max = 255)
    private String photoPath;

    @Column(name = "description")
    @Size(max = 1024)
    private String description;


    public Company() {
    }


    @Override
    public int hashCode() {
        int hash = 6;
        hash = 15 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Company other = (Company) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() 
    {
        return this.name;
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public Currency getCurrency() {return currency;}
    public void setCurrency(Currency currency) {this.currency = currency;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhotoPath() {return photoPath;}
    public void setPhotoPath(String photoPath) {this.photoPath = photoPath;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
}