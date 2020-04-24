package extend.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static extend.basic.Driver.getDriver;

public class Control {

   // public static Boolean isPageLoaded() {
    //    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
    //    return (Boolean) wait.until(((JavascriptExecutor)Driver.getDriver()));
    //            //.executeScript("return document.readyState.equals(\"loaded\" )"));

    //}

    public static Boolean isTextFieldEnabled(By locator){
        Boolean state = Boolean.FALSE;
        try {
            WebElement textElement = (new WebDriverWait(Driver.getDriver(), 10)).until(ExpectedConditions.presenceOfElementLocated(locator));
            state = textElement.isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
      return state;
    }
    public static Boolean isWebElementClickable(By locator) {
        Boolean state = Boolean.FALSE;
        try
        {
            WebDriverWait wait= new WebDriverWait(Driver.getDriver(), 60);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            state=element.isEnabled()&& element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }
    public static WebElement waitOnElementVisible(By locator) {
        WebElement webElement=null;
        try {
            webElement= (new WebDriverWait(Driver.getDriver(),10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }
    public static List<WebElement> waitOnElementsPresent(By locator) {
        List<WebElement> webElement=null;
        try {
            webElement= (new WebDriverWait(Driver.getDriver(),30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }
    public static WebElement waitOnElementPresent(By locator) {
        WebElement webElement=null;
        try {
            webElement= (new WebDriverWait(Driver.getDriver(),30)).until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }

    // }
     public static Boolean isWebElementSelected(By locator) {
         return getDriver().findElement(locator).isSelected();
     }
}