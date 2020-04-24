package extend.basic;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class Driver {
    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;
    private static final String IMAGEPATH = "/Users/Olga/Downloads/";
    public Driver() {
    }

    public static WebDriver initDriver(TargetPlatform targetPlatform){
        try {
            Class<?>  browserOptions = Class.forName(targetPlatform.getOptionsClassName());
            Object browserOptionsObject = browserOptions.getDeclaredConstructor().newInstance();
            Class<?>  driverName = Class.forName(targetPlatform.getDriverClassName());
            driver= (WebDriver) driverName.getDeclaredConstructor(browserOptions).newInstance(browserOptionsObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return driver;
    }
    public static WebDriver applyScreenShotOnError() {
            Driver.driver = new EventFiringWebDriver(driver).register(new AbstractWebDriverEventListener() {
            @Override
            public void onException(Throwable throwable, WebDriver driver) {
                super.onException(throwable, driver);
                File screenShot=((TakesScreenshot)Driver.driver).getScreenshotAs(OutputType.FILE);
                try {
                    screenShot.renameTo(new File(IMAGEPATH + driver.getTitle() +   ".png"));
                } catch (Exception e) {
                    e.printStackTrace();
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
