package journal.repositories;

import journal.models.entities.Role;
import journal.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Evgeniy Ukhanov
 */


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> getAll();

    Optional<Role> findByName(@Param("name") RoleEnum roleEnum);


    //  Кастомный метод, используется JPQL
//    @Query("SELECT r from Role r where name = :name")
//    Role findByName(@Param("name") String name);

    //  Кастомный метод с нативным SQL
//    @Query(value = "SELECT * FROM journal.role ORDER BY id", nativeQuery = true)
//    List<Role> findByAll();

}
