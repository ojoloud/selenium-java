package extend;

import extend.basic.Driver;
import extend.basic.TargetPlatformMethods;
import extend.util.PropertiesWrapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

abstract class BaseTest {
    public  PropertiesWrapper propertiesWrapper;
    //public WebDriver webDriver;

    @BeforeAll
    public static void init() {
        PropertiesWrapper.initProperties();
        String browser=PropertiesWrapper.getBaseProprties().get("browser").toString();
        Driver.initDriver(TargetPlatformMethods.getTargetPlatform(browser));
        //Driver.applyScreenShotOnError();
        Driver.maximizeWindows();
        //LoginPage.go("https://www.spicejet.com/");
        //LoginPage.go("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
    }
    @AfterAll
    public static void safe() {

    }

}
