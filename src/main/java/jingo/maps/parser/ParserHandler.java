package jingo.maps.parser;

import jingo.maps.query.Query;

import java.util.HashMap;
import java.util.Map;

public class ParserHandler {

    private static Map<Class<? extends Query>, QueryParser<? extends Query>> parserMap = new HashMap<>();

    public ParserHandler() {
        init();
    }

    private static void registerParser(QueryParser<? extends Query> parser) {
        parserMap.put(parser.getQueryClass(), parser);
    }

    public void init() {
        registerParser(new SimpleQueryParser());
        registerParser(new AdvancedQueryParser());
    }

    public QueryParser<?> getParser(Query query) {
        return parserMap.get(query.getClass());
    }

    public String parse(Query query) {
        if (query == null) {
            throw new IllegalArgumentException("Query could not be null");
        }

        return parserMap.get(query.getClass()).parse(query);
    }
}
