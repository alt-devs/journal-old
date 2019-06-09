package com.journal.repository;

import com.journal.model.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Evgeniy Ukhanov
 */


@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findById(long id);
}
