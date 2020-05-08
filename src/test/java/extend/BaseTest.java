package extend;

import extend.basic.Driver;
import extend.basic.TargetPlatformMethods;
import extend.pages.LoginPage;
import extend.util.FileConfigSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import java.util.Map;

abstract class BaseTest {
    public FileConfigSource configSource = new FileConfigSource();
    //public WebDriver webDriver;

    @BeforeAll
    public static void init() {
        FileConfigSource fileConfigSource = new FileConfigSource();
        Map propMap = fileConfigSource.getProperties();
        String url = propMap.get("url").toString();
        Driver.initDriver(TargetPlatformMethods
                .getTargetPlatform(propMap.get( "browser").toString()));
        Driver.maximizeWindows();
        Assertions.assertNotNull(url);
        LoginPage.go(url);
    }

    @AfterAll
    public static void clean() {
        Driver.getDriver().close();
    }

}
