package jingo.maps;

import jingo.maps.query.AdvancedQuery;
import jingo.maps.query.Query;
import jingo.maps.query.SimpleQuery;
import jingo.maps.result.JingoResult;
import jingo.maps.result.geocode.GeocodeResource;
import jingo.maps.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JingoWithMaxResultsTest {

    private JingoGeocoder geocoder;

    @Before
    public void getGeocoder() {
        this.geocoder = new JingoGeocoder(TestUtils.getTestKey());
    }

    @Test
    public void simpleGeocodeWithMaxResultsTest() throws IOException {
        Query query = givenASimpleQuery();
        JingoResult<GeocodeResource> result = geocoder.geocode(query);

        assertThat(result).isNotNull();
        assertThat(result.getAuthenticationResultCode()).isEqualTo("ValidCredentials");
        assertThat(result.getResourceSets()).isNotEmpty();
        assertThat(result.getStatusCode()).isEqualTo(200);
        assertThat(result.getResourceSets().get(0).getEstimatedTotal()).isNotNull();
        assertThat(result.getResourceSets().get(0).getEstimatedTotal()).isEqualTo(1);
    }

    @Test
    public void advancedGeocodeWithMaxResultsTest() throws IOException {
        Query query = givenAnAdvancedQuery();
        JingoResult<GeocodeResource> result = geocoder.geocode(query);

        assertThat(result).isNotNull();
        assertThat(result.getAuthenticationResultCode()).isEqualTo("ValidCredentials");
        assertThat(result.getResourceSets()).isNotEmpty();
        assertThat(result.getStatusCode()).isEqualTo(200);
        assertThat(result.getResourceSets().get(0).getEstimatedTotal()).isNotNull();
        assertThat(result.getResourceSets().get(0).getEstimatedTotal()).isEqualTo(1);
    }

    private Query givenASimpleQuery() {
        SimpleQuery query = new SimpleQuery();
        query.setQuery("Rua Santos Dumont, Redenção, Brasil, Ceará");
        query.setMaxResults(1);
        return query;
    }

    private Query givenAnAdvancedQuery() {
        AdvancedQuery query = new AdvancedQuery();
        query.setAddressLine("Rua Santos Dumont");
        query.setLocality("Redenção");
        query.setCountryRegion("Brasil");
        query.setMaxResults(1);
        return query;
    }

}
