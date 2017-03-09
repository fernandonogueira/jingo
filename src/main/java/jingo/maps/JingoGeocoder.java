package jingo.maps;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jingo.maps.parser.ParserHandler;
import jingo.maps.query.Query;
import jingo.maps.result.JingoResult;
import jingo.maps.result.geocode.GeocodeResource;
import jingo.maps.util.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JingoGeocoder {

    public static final String DEFAULT_BING_URL = "http://dev.virtualearth.net/REST/v1/Locations";
    private static final Logger LOGGER = LoggerFactory.getLogger(JingoGeocoder.class);
    private static final int DEFAULT_CONNECT_TIMEOUT = 30000;
    private static final int DEFAULT_READ_TIMEOUT = 30000;

    private final String key;
    private final String baseUrl;
    private final int connectTimeout;
    private final int readTimeout;

    private ParserHandler parserHandler = new ParserHandler();

    private ObjectMapper objectMapper = JacksonUtils.getObjectMapper();

    public JingoGeocoder(String key) {
        this(DEFAULT_BING_URL, key, DEFAULT_CONNECT_TIMEOUT, DEFAULT_READ_TIMEOUT);
    }

    public JingoGeocoder(String baseUrl, String key, int connectTimeout, int readTimeout) {

        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new IllegalArgumentException("baseUrl could not be empty");
        }

        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("key could not be empty");
        }

        this.key = key;
        this.baseUrl = baseUrl;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    /**
     * Geocode an address based on a Query.
     * <p>
     * For now, you may choose
     * between Advanced Queries ({@link jingo.maps.query.AdvancedQuery}) or Simple Queries ({@link jingo.maps.query.SimpleQuery})
     *
     * @param query The {@link Query} object
     * @return The Geocoding request result {@link JingoResult}
     * @throws IOException when something unexpected happens
     */
    public JingoResult<GeocodeResource> geocode(Query query) throws IOException {
        String url = prepareURL(query);

        try {
            URL nUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) nUrl.openConnection();
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            conn.setRequestMethod("GET");
            conn.connect();

            int code = conn.getResponseCode();

            if (code != 200) {
                JingoResult<GeocodeResource> notOkResult = new JingoResult<>();
                notOkResult.setStatusCode(code);
                return notOkResult;
            }
            Reader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            try {
                return objectMapper.readValue(reader, new TypeReference<JingoResult<GeocodeResource>>() {
                });
            } catch (JsonParseException | JsonMappingException e) {
                LOGGER.error("Error parsing Jingo response", e);
            } catch (IOException e) {
                LOGGER.error("IOException trying to geocode", e);
            } finally {
                reader.close();
            }
        } catch (MalformedURLException e) {
            LOGGER.error("Jingo error trying to geocode", e);
        }

        return null;
    }

    private String prepareURL(Query query) {
        return baseUrl + "?" + parseQuery(query) + "&output=json&key=" + key;
    }

    private String parseQuery(Query query) {
        return parserHandler.parse(query);
    }

}
