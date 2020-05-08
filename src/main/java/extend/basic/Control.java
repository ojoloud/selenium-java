package extend.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static extend.basic.Driver.getDriver;

public class Control {
    public static final Logger logger = LoggerFactory.getLogger(Control.class);
    public static Boolean isTextFieldEnabled(By locator) {
        try {
            WebElement textElement = (new WebDriverWait(Driver.getDriver(), 10)).until(ExpectedConditions.presenceOfElementLocated(locator));
            return textElement.isEnabled();
        } catch (Exception e) {
            logger.error("Exception occurred:  {} ", e);
        }

        return Boolean.FALSE;
    }

    public static Boolean isWebElementClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isEnabled() && element.isDisplayed();
        } catch (Exception e) {
            logger.error("Exception occurred:  {} ", e);
        }
        return Boolean.FALSE;
    }

    public static WebElement waitOnElementVisible(By locator) {
        try {
            WebElement webElement = (new WebDriverWait(Driver.getDriver(), 30)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return webElement;
        } catch (Exception e) {
            logger.error("Exception occurred:  {} ", e);
        }
        return null;
    }

    public static List<WebElement> waitOnElementsPresent(By locator) {
        try {
            List <WebElement> webElement = (new WebDriverWait(Driver.getDriver(), 30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            return webElement;
        } catch (Exception e) {
            logger.error("Exception occurred:  {} ", e);
        }
        return null;
    }

    public static WebElement waitOnElementPresent(By locator) {
        try {
            WebElement webElement = (new WebDriverWait(Driver.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(locator));
            return webElement;
        } catch (Exception e) {
            logger.error("Exception occurred: {} ", e);
            e.printStackTrace();
        }
        return null;
    }

    // }
    public static Boolean isWebElementSelected(By locator) {
        return getDriver().findElement(locator).isSelected();
    }
}