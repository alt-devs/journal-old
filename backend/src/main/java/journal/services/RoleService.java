package journal.services;

import journal.models.entities.Role;
import journal.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Evgeniy Ukhanov
 */


public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
