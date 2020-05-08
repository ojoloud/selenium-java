package extend.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TargetPlatformMethods {
    public static TargetPlatform supportedPlatform = TargetPlatform.CHROME;
    public static final Logger logger = LoggerFactory.getLogger(TargetPlatformMethods.class);

    public TargetPlatformMethods() {
    }

    public static TargetPlatform getTargetPlatform(String browser) {
        if (browser == null) {
            throw new NullPointerException("Argument null, browser name");
        } else {
            logger.debug("browser name {} ", browser);
            for (TargetPlatform iPlatform : TargetPlatform.values()) {
                if (iPlatform.getPlatform().equalsIgnoreCase(browser)) {
                    supportedPlatform = iPlatform;
                    break;
                }
            }
        }
        if (supportedPlatform == null) {
            logger.error("browser: {} browser not supported", browser);
            throw new NullPointerException("browser: " + browser + "not supported");
        }
        return supportedPlatform;
    }
}
