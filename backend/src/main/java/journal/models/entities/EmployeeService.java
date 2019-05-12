package journal.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


/**
 * @author Evgeniy Ukhanov
 */


@Entity
@Table(name = "journal.employee_service")
public class EmployeeService implements Serializable {

    private static final long serialVersionUID = 4543082935802115434L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_service_seq_gen")
    @SequenceGenerator(name = "employee_service_seq_gen", sequenceName = "journal.employee_service_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "id_company_service", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private CompanyService companyService;

    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @Column(name = "duration")
    private int duration;

    @Column(name = "cost")
    private long cost;

    @Column(name = "is_floating_price")
    private boolean isFloatingPrice;

    @Column(name = "is_online_enable")
    private boolean isOnlineEnable;


    public EmployeeService() {
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
        
        final EmployeeService other = (EmployeeService) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() 
    {
        return String.valueOf(this.id);
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public CompanyService getCompanyService() {return companyService;}
    public void setCompanyService(CompanyService companyService) {this.companyService = companyService;}

    public Employee getEmployee() {return employee;}
    public void setEmployee(Employee employee) {this.employee = employee;}

    public int getDuration() {return duration;}
    public void setDuration(int duration) {this.duration = duration;}

    public long getCost() {return cost;}
    public void setCost(long cost) {this.cost = cost;}

    public boolean isFloatingPrice() {return isFloatingPrice;}
    public void setIsFloatingPrice(boolean isFloatingPrice) {this.isFloatingPrice = isFloatingPrice;}

    public boolean isOnlineEnable() {return isOnlineEnable;}
    public void setIsOnlineEnable(boolean isOnlineEnable) {this.isOnlineEnable = isOnlineEnable;}
}