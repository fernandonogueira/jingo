package jingo.maps;

import jingo.maps.query.SimpleQuery;
import jingo.maps.result.JingoResult;
import jingo.maps.result.geocode.GeocodeResource;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class WrongKeyTest {

    @Test
    public void wrongKeyTest() throws IOException {
        JingoGeocoder jingo = new JingoGeocoder("123");

        SimpleQuery q = new SimpleQuery();
        q.setQuery("Brasilia, Brasil");
        JingoResult<GeocodeResource> result = jingo.geocode(q);

        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isNotEqualTo(200);
        assertThat(result.getResourceSets()).isNull();
    }

}
