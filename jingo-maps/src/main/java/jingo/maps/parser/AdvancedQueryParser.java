package jingo.maps.parser;

import jingo.maps.query.AdvancedQuery;
import jingo.maps.query.Query;

public class AdvancedQueryParser implements QueryParser<AdvancedQuery> {

    @Override
    public Class<AdvancedQuery> getQueryClass() {
        return AdvancedQuery.class;
    }

    public String parse(Query query) {

        if (query == null) {
            throw new IllegalArgumentException("Query could not be null");
        }

        if (!(query instanceof AdvancedQuery)) {
            throw new IllegalArgumentException("Illegal query type. " +
                    "This parser supports only AdvancedQuery objects");
        }

        return "";
    }

}
