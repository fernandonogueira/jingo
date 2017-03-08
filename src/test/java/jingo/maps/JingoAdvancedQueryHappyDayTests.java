package jingo.maps;

import jingo.maps.query.AdvancedQuery;
import jingo.maps.query.Query;
import jingo.maps.result.JingoResult;
import jingo.maps.result.geocode.GeocodeResource;
import jingo.maps.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JingoAdvancedQueryHappyDayTests {

    private JingoGeocoder geocoder;

    @Before
    public void getGeocoder() {
        this.geocoder = new JingoGeocoder(TestUtils.getTestKey());
    }

    @Test
    public void simpleGeocodeTest() throws IOException {
        Query query = givenAnAdvancedQuery();
        JingoResult<GeocodeResource> result = geocoder.geocode(query);

        assertThat(result).isNotNull();
        assertThat(result.getAuthenticationResultCode()).isEqualTo("ValidCredentials");
        assertThat(result.getResourceSets()).isNotEmpty();
        assertThat(result.getResourceSets().get(0).getEstimatedTotal()).isNotNull();
        assertThat(result.getResourceSets().get(0).getResources()).isNotEmpty();
        assertThat(result.getResourceSets().get(0).getResources().get(0).getBbox()).isNotNull();
        assertThat(result.getResourceSets().get(0).getResources().get(0).getBbox().length).isNotZero();
    }

    private Query givenAnAdvancedQuery() {
        AdvancedQuery query = new AdvancedQuery();

        query.setAddressLine("Rua Santos Dumont");
        query.setLocality("Redenção");
        query.setAdminDistrict("Ceará");
        query.setCountryRegion("Brasil");

        return query;
    }

}
