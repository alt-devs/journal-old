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
@Table(name = "journal.client")
public class Client implements Serializable {

	private static final long serialVersionUID = -7063663198054938091L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "client_seq_gen")
    @SequenceGenerator(name = "client_seq_gen", sequenceName = "journal.client_id_seq", allocationSize = 1)
    @NotNull
    @Column(name = "id")
    private long id;

    @Column(name = "surname")
    @Size(max = 30)
    private String surname;


    public Client() {
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
        
        final Client other = (Client) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() 
    {
        return this.surname;
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
}