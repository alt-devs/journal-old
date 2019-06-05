package com.journal.service;


import com.journal.model.entity.Currency;
import com.journal.repository.CurrencyRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Evgeniy Ukhanov
 */


@Service
public class CurrencyService {

//    @Autowired
//    private CurrencyRepository currencyRepository;

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }


    @GraphQLQuery(name = "currencies")
//    @PreAuthorize("isAnonymous() OR hasRole('USER')")
//    @PreAuthorize("hasRole('USER')")
    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    @GraphQLQuery(name = "currency")
    public Optional<Currency> getCarById(@GraphQLArgument(name = "id") Long id) {
        return currencyRepository.findById(id);
    }

}