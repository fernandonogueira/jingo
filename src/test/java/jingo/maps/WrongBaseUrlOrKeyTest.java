package jingo.maps;

import org.junit.Test;

public class WrongBaseUrlOrKeyTest {

    @Test(expected = IllegalArgumentException.class)
    public void wrongBaseUrlTest() {
        new JingoGeocoder(null, "123", 30000, 30000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongKeyTest() {
        new JingoGeocoder(JingoGeocoder.DEFAULT_BING_URL, null, 30000, 30000);
    }
}
