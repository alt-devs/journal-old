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
@Table(name = "journal.industry_area")
public class IndustryArea implements Serializable {

    private static final long serialVersionUID = 5517524344936351973L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "industry_area_seq_gen")
    @SequenceGenerator(name = "industry_area_seq_gen", sequenceName = "journal.industry_area_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "id_industry", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Industry industry;

    @Column(name = "name")
    @Size(max = 100)
    private String name;


    public IndustryArea() {
    }


    @Override
    public int hashCode() {
        int hash = 9;
        hash = 14 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final IndustryArea other = (IndustryArea) obj;
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

    public Industry getIndustry() {return industry;}
    public void setIndustry(Industry industry) {this.industry = industry;}
}