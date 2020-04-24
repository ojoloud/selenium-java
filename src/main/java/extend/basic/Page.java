package extend.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static extend.basic.Driver.getDriver;


public class Page {

    public Page() {
    }
    public static class PageBuilder {

        public static PageBuilder newInstance () {
            return new PageBuilder();
        }
        public PageBuilder setText(By locator, String text) {
            if (Control.isTextFieldEnabled(locator)) {
                getDriver().findElement(locator).clear();
                getDriver().findElement(locator).sendKeys(text);
            } else {
                throw new ElementNotSelectableException("Text field can not be edited");
            }
            return this;
        }

        public PageBuilder searchAutoSuggestions (By locator, String text) throws InterruptedException{
            if (Control.isTextFieldEnabled(locator)) {
                getDriver().findElement(locator).clear();
                getDriver().findElement(locator).sendKeys(text);
                Thread.sleep(10000);
            } else {
                throw new ElementNotSelectableException("Text field can not be edited");
            }
            return this;
        }
        public PageBuilder getTextJS(By locator, String text){
            return this;
        }

        public PageBuilder go(String url) {
            getDriver().get(url);
            return this;
        }

        public PageBuilder selectSubMenuByLocator(By locator, By locator1) {
            Actions advancedActions = new Actions(getDriver());
            if (Control.isWebElementClickable(locator)) {
                getDriver().findElement(locator).click();
                WebElement submenuElement = Control.waitOnElementVisible(locator1);
                if (submenuElement != null) {
                    advancedActions.moveToElement(submenuElement)
                            .click()
                            .build()
                            .perform();
                } else {
                    throw new NullPointerException("SubMenue Element null");
                }

            } else {
                throw new ElementNotInteractableException("Menue button neither not Displayed,  not Enabled"+ locator.toString());
            }
            return this;
        }

        // public static void selectMenuByLocator(By locator){
        //     Actions advancedActions = new Actions(getDriver());
        //     Control.waitOnElementsPresent(locator);

        public PageBuilder selectWebElement(By locator) {
            if (Control.isWebElementClickable(locator)) {
                getDriver().findElement(locator).click();
            } else {
                throw new ElementNotInteractableException("Element neither not Displayed");
            }
            return this;
        }
        //Counts
        public static List<WebElement> getClickableElements (By locator){
            List<WebElement> webElementCnt = Control.waitOnElementsPresent(locator).stream()
                    .filter(item -> item.isDisplayed())
                    .filter(item -> item.isEnabled())
                    .collect(Collectors.toList());
            return webElementCnt;
        }

        public static int getClickableElementsCountOn (By frameLocator, By locator ){
            return  getClickableElementsOnFrame(frameLocator,locator).size();

        }
        public static List<WebElement> getClickableElementsOnFrame (By frameLocator, By locator ){
            WebElement webElement = Control.waitOnElementPresent(frameLocator);
            List <WebElement> myElements =webElement.findElements(locator)
                    .stream()
                    .filter(item -> item.isDisplayed())
                    .filter(item -> item.isEnabled())
                    .collect(Collectors.toList());

            return myElements;
        }
        //Alert functions
        public PageBuilder acceptAlert() {
            try {
                getDriver().switchTo().alert().accept();
            } catch (NoAlertPresentException e){
                e.printStackTrace();
            }
            return this;
        }
        public static String getPageTitle() {
            return getDriver().getTitle();
        }
        // Windows Functions
        public PageBuilder moveTodWindows(String window) {
            getDriver().switchTo().window(window);
            return this;
        }
        public static Set<String> getWindowsHandles() {
            Set<String> windowsHandles= getDriver().getWindowHandles();
            return windowsHandles;
        }
        //Frame Functions
        public PageBuilder moveToFrame(WebElement window) {
            try {
                getDriver().switchTo().frame(window);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this;
        }
        public PageBuilder returnContextBack() {
            getDriver().switchTo().defaultContent();
            return this;
        }

        public void clickAlertTrigger(By locator) {
            this.selectWebElement(locator);
        }
    }
    //WebElement

}