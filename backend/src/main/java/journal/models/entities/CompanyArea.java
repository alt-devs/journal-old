package journal.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


/**
 * @author Evgeniy Ukhanov
 */


@Entity
@Table(name = "journal.company_area")
public class CompanyArea implements Serializable {

    private static final long serialVersionUID = 6444321840195954762L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "company_area_seq_gen")
    @SequenceGenerator(name = "company_area_seq_gen", sequenceName = "journal.company_area_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "id_company", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Company company;

    @JoinColumn(name = "id_industry_area", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private IndustryArea industryArea;


    public CompanyArea() {
    }


    @Override
    public int hashCode() {
        int hash = 11;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final CompanyArea other = (CompanyArea) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() 
    {
        return String.valueOf(this.id);
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public Company getCompany() {return company;}
    public void setCompany(Company company) {this.company = company;}

    public IndustryArea getIndustryArea() {return industryArea;}
    public void setIndustryArea(IndustryArea industryArea) {this.industryArea = industryArea;}
}