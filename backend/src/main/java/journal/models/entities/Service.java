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
@Table(name = "journal.employee_service")
public class Service implements Serializable {

    private static final long serialVersionUID = 4299941718815726424L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_service_seq_gen")
    @SequenceGenerator(name = "employee_service_seq_gen", sequenceName = "journal.employee_service_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "id_service_category", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private ServiceCategory serviceCategory;

    @Column(name = "name")
    @Size(max = 100)
    private String name;


    public Service() {
    }


    @Override
    public int hashCode() {
        int hash = 13;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Service other = (Service) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() 
    {
        return String.valueOf(this.id);
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public ServiceCategory getServiceCategory() {return serviceCategory;}
    public void setServiceCategory(ServiceCategory serviceCategory) {this.serviceCategory = serviceCategory;}
}