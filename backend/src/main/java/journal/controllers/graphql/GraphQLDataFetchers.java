package journal.controllers.graphql;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import graphql.schema.DataFetcher;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Evgeniy Ukhanov
 * Тестовый набор данных. Затем переделать на загрузку данных из БД
 */


@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> currencies = Arrays.asList(
            ImmutableMap.of("id", "1",
                    "name", "Российский рубль"),
            ImmutableMap.of("id", "2",
                    "name", "Грузинский лари"),
            ImmutableMap.of("id", "3",
                    "name", "Казахский тенге")
    );


    public DataFetcher getCurrencyByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String currencyId = dataFetchingEnvironment.getArgument("id");
            return currencies
                    .stream()
                    .filter(currency -> currency.get("id").equals(currencyId))
                    .findFirst()
                    .orElse(null);
        };
    }

}
