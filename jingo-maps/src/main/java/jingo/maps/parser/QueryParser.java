package jingo.maps.parser;

import jingo.maps.query.Query;

public interface QueryParser<Q extends Query> {

    /**
     * Returns the Query type that this parser knows how to parse
     * @return the class type
     */
    Class<Q> getQueryType();

    String parse(Query query);

}