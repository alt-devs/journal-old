package com.journal.repository;

import com.journal.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Evgeniy Ukhanov
 */


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String roleName);
//    Optional<Role> findByName(RoleName roleName);
}