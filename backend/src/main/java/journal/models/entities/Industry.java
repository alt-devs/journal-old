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
@Table(name = "journal.industry")
public class Industry implements Serializable {

    private static final long serialVersionUID = -2418735755797198193L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "industry_seq_gen")
    @SequenceGenerator(name = "industry_seq_gen", sequenceName = "journal.industry_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @Size(max = 50)
    private String name;


    public Industry() {
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Industry other = (Industry) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() 
    {
        return this.name;
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}