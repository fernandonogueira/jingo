package jingo.maps.parser;


import jingo.maps.query.Query;
import jingo.maps.query.SimpleQuery;

import java.io.UnsupportedEncodingException;

public class SimpleQueryParser implements QueryParser<SimpleQuery> {

    @Override
    public Class<SimpleQuery> getQueryClass() {
        return SimpleQuery.class;
    }

    @Override
    public String parse(Query query) {

        if (query == null) {
            throw new IllegalArgumentException("Query could not be null");
        }

        if (!(query instanceof SimpleQuery)) {
            throw new IllegalArgumentException("Illegal query type. " +
                    "This parser supports only SimpleQuery objects");
        }

        SimpleQuery simpleQuery = (SimpleQuery) query;

        String str = "";

        if (simpleQuery.getQuery() != null && !simpleQuery.getQuery().isEmpty()) {
            try {
                str += "q=" + java.net.URLEncoder.encode(simpleQuery.getQuery(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException("Parsing exception", e);
            }
        } else {
            throw new IllegalArgumentException("Query could not be empty");
        }

        if (simpleQuery.getMaxResults() != null) {
            str += "&maxResults=" + simpleQuery.getMaxResults();
        }

        return str;
    }
}
