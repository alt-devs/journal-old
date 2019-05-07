package journal.services;

import journal.models.entities.Role;
import journal.models.enums.RoleEnum;
import journal.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author Evgeniy Ukhanov
 */


public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public Optional<Role> findByName(RoleEnum roleEnum) {
        return roleRepository.findByName(roleEnum);
    }


    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
