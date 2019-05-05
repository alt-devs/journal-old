package journal.controllers.graphql;

import graphql.schema.DataFetchingEnvironment;

/**
 * @author Evgeniy Ukhanov
 */


public interface DataFetcher<T> {
    T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}
