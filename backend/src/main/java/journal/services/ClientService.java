package journal.services;

import journal.models.entities.Client;
import journal.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeniy Ukhanov
 */


public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client addClient(Client client) {
        Client savedClient = clientRepository.saveAndFlush(client);

        return savedClient;
    }


    public Client updateClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }


    public void delete(Client client) {
        clientRepository.delete(client);
    }


    public Client getById(long id) {
        return clientRepository.getOne(id);
    }


//    @Override
//    public List<Client> getAll() {
//        return clientRepository.findAll();
//    }
}
