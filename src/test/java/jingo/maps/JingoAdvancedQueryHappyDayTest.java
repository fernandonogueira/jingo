package jingo.maps;

import jingo.maps.geo.Address;
import jingo.maps.geo.LocationTypeName;
import jingo.maps.geo.Point;
import jingo.maps.query.AdvancedQuery;
import jingo.maps.query.Query;
import jingo.maps.result.JingoResult;
import jingo.maps.result.ResourceSet;
import jingo.maps.result.geocode.GeocodeResource;
import jingo.maps.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JingoAdvancedQueryHappyDayTest {

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

        ResourceSet<GeocodeResource> resourceSet = result.getResourceSets().get(0);

        assertThat(resourceSet.getEstimatedTotal()).isNotNull();
        assertThat(resourceSet.getResources()).isNotEmpty();

        List<GeocodeResource> resourceList = resourceSet.getResources();

        GeocodeResource firstResource = resourceList.get(0);

        assertThat(firstResource.getBbox()).isNotNull();
        assertThat(firstResource.getBbox().length).isNotZero();

        assertThat(firstResource.getAddress()).isNotNull();

        assertThat(firstResource.getPoint()).isNotNull();
        Point point = firstResource.getPoint();

        assertThat(point.getCoordinates()).isNotEmpty();
        assertThat(point.getType()).isEqualTo(LocationTypeName.POINT.getName());

        Address addr = firstResource.getAddress();
        assertThat(addr.getAddressLine()).isNotEmpty();

        assertThat(addr.getLocality()).isNotEmpty();
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
