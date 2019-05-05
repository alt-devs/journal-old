package journal.repositories;

import journal.models.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Evgeniy Ukhanov
 */


@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
