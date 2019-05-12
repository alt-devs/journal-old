package journal.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * @author Evgeniy Ukhanov
 */


@Entity
@Table(name = "journal.employee_schedule")
public class EmployeeSchedule implements Serializable {

    private static final long serialVersionUID = -5803666787291759369L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_schedule_seq_gen")
    @SequenceGenerator(name = "employee_schedule_seq_gen", sequenceName = "journal.employee_schedule_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_datetime")
    private Date startDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_datetime")
    private Date endDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "break_start_datetime")
    private Date breakStartDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "break_end_datetime")
    private Date breakEndDatetime;

    @Column(name = "reception_interval")
    private long receptionInterval;


    public EmployeeSchedule() {
    }


    @Override
    public int hashCode() {
        int hash = 15;
        hash = 21 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final EmployeeSchedule other = (EmployeeSchedule) obj;
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

    public Date getStartDatetime() {return startDatetime;}
    public void setStartDatetime(Date startDatetime) {this.startDatetime = startDatetime;}

    public Date getEndDatetime() {return endDatetime;}
    public void setEndDatetime(Date endDatetime) {this.endDatetime = endDatetime;}

    public Date getBreakStartDatetime() {return breakStartDatetime;}
    public void setBreakStartDatetime(Date breakStartDatetime) {this.breakStartDatetime = breakStartDatetime;}

    public Date getBreakEndDatetime() {return breakEndDatetime;}
    public void setBreakEndDatetime(Date breakEndDatetime) {this.breakEndDatetime = breakEndDatetime;}

    public long getReceptionInterval() {return receptionInterval;}
    public void setReceptionInterval(long receptionInterval) {this.receptionInterval = receptionInterval;}
}