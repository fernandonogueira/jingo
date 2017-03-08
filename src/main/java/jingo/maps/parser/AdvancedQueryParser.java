package jingo.maps.parser;

import jingo.maps.query.AdvancedQuery;
import jingo.maps.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class AdvancedQueryParser implements QueryParser<AdvancedQuery> {

    private static Logger LOGGER = LoggerFactory.getLogger(AdvancedQueryParser.class);

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

        AdvancedQuery advancedQuery = (AdvancedQuery) query;

        String str = "";

        str = concatIfPresent("addressLine", advancedQuery.getAddressLine(), str);
        str = concatIfPresent("adminDistrict", advancedQuery.getAdminDistrict(), str);
        str = concatIfPresent("countryRegion", advancedQuery.getCountryRegion(), str);
        str = concatIfPresent("includeNeighborhood", advancedQuery.getIncludeNeighborhood(), str);
        str = concatIfPresent("locality", advancedQuery.getLocality(), str);
        str = concatIfPresent("postalCode", advancedQuery.getPostalCode(), str);
        str = concatIfPresent("userLocation", advancedQuery.getUserLocation(), str);
        str = concatIfPresent("maxResults", advancedQuery.getMaxResults(), str);

        return str;
    }

    private String concatIfPresent(String property, Object value, String currentStr) {
        if (value != null) {
            String stringVal = String.valueOf(value);
            currentStr = addSeparatorIfNecessary(currentStr);
            try {
                currentStr += property + "=" + java.net.URLEncoder.encode(stringVal, "utf-8");
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("Error parsing Jingo query", e);
            }
        }
        return currentStr;
    }

    private String addSeparatorIfNecessary(String str) {
        return !str.isEmpty() ? str + "&" : str;
    }

}
