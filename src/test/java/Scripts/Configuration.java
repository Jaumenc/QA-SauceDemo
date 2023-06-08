package Scripts;

import java.util.Properties;

public class Configuration {
    public static final String PROPERTIES_FILE_PATH = "src/test/resources/Properties/";
    public static final String KEY_PROPERTIES_FILE_PATH = PROPERTIES_FILE_PATH+"keys_%s.properties";
    public static final Properties KEY_PROPERTIES_FILE = Commons.getProperties(String.format(KEY_PROPERTIES_FILE_PATH, "EN"));
}
