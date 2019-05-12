package journal.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


/**
 * @author Evgeniy Ukhanov
 */


@Entity
@Table(name = "journal.employee_service_category")
public class EmployeeServiceCategory implements Serializable {

    private static final long serialVersionUID = 2990808595617450857L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_service_category_seq_gen")
    @SequenceGenerator(name = "employee_service_category_seq_gen", sequenceName = "journal.employee_service_category_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @JoinColumn(name = "id_company_service_category", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private CompanyServiceCategory companyServiceCategory;


    public EmployeeServiceCategory() {
    }


    @Override
    public int hashCode() {
        int hash = 9;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final EmployeeServiceCategory other = (EmployeeServiceCategory) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() 
    {
        return String.valueOf(this.id);
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public Employee getEmployee() {return employee;}
    public void setEmployee(Employee employee) {this.employee = employee;}

    public CompanyServiceCategory getCompanyServiceCategory() {return companyServiceCategory;}
    public void setCompanyServiceCategory(CompanyServiceCategory companyServiceCategory) {this.companyServiceCategory = companyServiceCategory;}
}