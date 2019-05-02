/**
 * Created by Evgeniy Ukhanov on 02.05.2019.
 */

package journal.services.graphql;

import graphql.schema.DataFetchingEnvironment;


public interface DataFetcher<T> {
    T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}
