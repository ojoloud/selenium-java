package extend.basic;

import extend.util.PropertiesWrapper;

public class TargetPlatformMethods {
    public static TargetPlatform supportedPlatform=TargetPlatform.CHROME;

    public TargetPlatformMethods() {
    }

    public static TargetPlatform getTargetPlatform(String browser){
        if (browser == null) {
            throw new NullPointerException("Argument null");
        } else {
            for (TargetPlatform iPlatform:TargetPlatform.values()) {
                 if (iPlatform.getPlatform().equalsIgnoreCase(browser)) {
                    supportedPlatform=iPlatform;
                    break;
                 }
            }
        }
        if (supportedPlatform==null){
            throw new NullPointerException("brower: " + browser + "not supported");
        }
       return supportedPlatform;
    }
}
