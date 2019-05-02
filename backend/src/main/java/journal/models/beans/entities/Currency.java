/**
 * Created by Evgeniy Ukhanov on 02.05.2019.
 */

package journal.models.beans.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "journal.currency")
public class Currency implements Serializable {

    private static final long serialVersionUID = -783040864613173915L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "currency_seq_gen")
    @SequenceGenerator(name = "currency_seq_gen", sequenceName = "journal.currency_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @Size(max = 50)
    private String name;


    public Currency() {
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
        
        final Currency other = (Currency) obj;
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