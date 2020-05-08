package extend.util;

import java.util.Map;
import java.util.Set;

public interface ConfigSource {
    Map getProperties();

    Set getNames();

    String getValue(String key);
}
