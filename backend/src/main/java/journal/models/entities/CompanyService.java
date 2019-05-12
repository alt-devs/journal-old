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
@Table(name = "journal.company_service")
public class CompanyService implements Serializable {

    private static final long serialVersionUID = 8860355739464192047L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "company_service_seq_gen")
    @SequenceGenerator(name = "company_service_seq_gen", sequenceName = "journal.company_service_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "id_service_category", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private CompanyServiceCategory companyServiceCategory;

    @JoinColumn(name = "id_company", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Company company;

    @Column(name = "name")
    @Size(max = 255)
    private String name;

    @Column(name = "service_code")
    @Size(max = 10)
    private String serviceCode;

    @Column(name = "is_disabled")
    private boolean isDisabled;

    @Column(name = "description")
    @Size(max = 512)
    private String description;


    public CompanyService() {
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
        
        final CompanyService other = (CompanyService) obj;
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

    public CompanyServiceCategory getCompanyServiceCategory() {return companyServiceCategory;}
    public void setCompanyServiceCategory(CompanyServiceCategory companyServiceCategory) {this.companyServiceCategory = companyServiceCategory;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getServiceCode() {return serviceCode;}
    public void setServiceCode(String serviceCode) {this.serviceCode = serviceCode;}

    public boolean getIsDisabled() {return isDisabled;}
    public void setIsDisabled(boolean isDisabled) {this.isDisabled = isDisabled;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
}