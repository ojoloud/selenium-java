package extend.util;

import java.io.*;
import java.util.Properties;

public class PropertiesWrapper {
    private static final String FILENAME = new File("target/classes/selenium.properties").getAbsolutePath();
    private static Properties baseProprties = new Properties();
    public static Properties getBaseProprties() {
        return baseProprties;
    }
    public PropertiesWrapper() {
    }

    public static void initProperties() {
        try {
            baseProprties.load(new FileInputStream(FILENAME));
        } catch (IOException e) {
            baseProprties.clear();
        }
    }
}
