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
@Table(name = "journal.service_category")
public class ServiceCategory implements Serializable {

    private static final long serialVersionUID = -6145438040847747381L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "service_category_seq_gen")
    @SequenceGenerator(name = "service_category_seq_gen", sequenceName = "journal.service_category_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @Size(max = 100)
    private String name;


    public ServiceCategory() {
    }


    @Override
    public int hashCode() {
        int hash = 4;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final ServiceCategory other = (ServiceCategory) obj;
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