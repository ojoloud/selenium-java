package extend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

public class FileConfigSource implements ConfigSource {
    private static final String FILENAME = new File("target/classes/selenium.properties").getAbsolutePath();
    public final Logger logger = LoggerFactory.getLogger(FileConfigSource.class);
    public FileConfigSource() {
    }

    @Override
    public Map getProperties() {
        try {
            InputStream inputStream = new FileInputStream(FILENAME);
            Properties properties = new Properties();
            properties.load(inputStream);
            Map propMap = properties.stringPropertyNames()
                    .stream().collect(Collectors.toMap(key -> key, key -> properties.getProperty(key, "None"), (a, b) -> b));
            return propMap;
        } catch (IOException e) {
            logger.error("Exception occurred:  {} ", e);
        }

        return null;
    }

    @Override
    public Set getNames() {
        try {
            InputStream inputStream = new FileInputStream(FILENAME);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.stringPropertyNames();
        } catch (IOException e) {
            logger.error("Exception occurred:  {} ", e);
        }
        return null;
    }

    @Override
    public String getValue(String key) {
        try {
            InputStream inputStream = new FileInputStream(FILENAME);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(key, "None");
        } catch (IOException e) {
            logger.error("Exception occurred:  {} ", e);
        }
        return null;
    }
}