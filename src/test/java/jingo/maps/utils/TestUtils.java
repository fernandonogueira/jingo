package jingo.maps.utils;

public class TestUtils {

    public static String getTestKey() {
        String key = System.getProperty("JINGO_TEST_KEY");

        if (key == null || key.isEmpty()) {
            // verify if property is being passed by env vars
            key = System.getenv("JINGO_TEST_KEY");
        }

        if (key == null || key.isEmpty()) {
            throw new RuntimeException("Could not start tests because JINGO_TEST_KEY is not set. " +
                    "Set it passing it as an environment variable. (-DJINGO_TEST_KEY=yourKey)");
        }

        return key;
    }

}
