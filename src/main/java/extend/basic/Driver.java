package extend.basic;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;

public class Driver {
    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;
    private static final String IMAGEPATH = "/var/tmp/";
    public static final Logger logger = LoggerFactory.getLogger(Driver.class);

    public Driver() {
    }

    public static WebDriver initDriver(TargetPlatform targetPlatform) {
        try {
            Class<?> browserOptions = Class.forName(targetPlatform.getOptionsClassName());
            Object browserOptionsObject = browserOptions.getDeclaredConstructor().newInstance();
            Class<?> driverName = Class.forName(targetPlatform.getDriverClassName());
            driver = (WebDriver) driverName.getDeclaredConstructor(browserOptions).newInstance(browserOptionsObject);
            logger.info("initialized driver {} ", driverName);
        } catch (ClassNotFoundException e) {
            logger.error("Exception occurred: {} ", e.getStackTrace());
        } catch (NoSuchMethodException e) {
            logger.error("Exception occurred: {} ", e.getStackTrace());
        } catch (InstantiationException e) {
            logger.error("Exception occurred: {} ", e.getStackTrace());
        } catch (IllegalAccessException e) {
            logger.error("Exception occurred: {} ", e.getStackTrace());
        } catch (InvocationTargetException e) {
            logger.error("Exception occurred: {} ", e.getStackTrace());
        }
        return driver;
    }

    public static WebDriver applyScreenShotOnError(Path filePath) {
        logger.debug("screen shot path {}", filePath.toString());
        Driver.driver = new EventFiringWebDriver(driver).register(new AbstractWebDriverEventListener() {
            @Override
            public void onException(Throwable throwable, WebDriver driver) {
                super.onException(throwable, driver);
                File screenShot = ((TakesScreenshot) Driver.driver).getScreenshotAs(OutputType.FILE);
                try {
                    screenShot.renameTo(new File(filePath + driver.getTitle() + ".png"));
                } catch (Exception e) {
                    logger.error("Exception occurred: {} ", e.getStackTrace());
                }
            }
        });
        return Driver.driver;
    }

    public static void maximizeWindows() {
        Driver.driver.manage().window().maximize();
    }

    public static void closeDriver() {
        Driver.getDriver().close();
    }
}
