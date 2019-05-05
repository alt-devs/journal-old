package journal.repositories;

import journal.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Evgeniy Ukhanov
 */


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client addClient(Client client);
    Client updateClient(Client client);
    void delete(Client client);

    Client getById(long id);

//    List<Client> getAll();
}
