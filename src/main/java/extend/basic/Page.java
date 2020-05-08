package extend.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static extend.basic.Driver.getDriver;


public class Page {

    public Page() {
    }

    public static class PageBuilder {
        public static final Logger logger = LoggerFactory.getLogger(Page.class);

        public static PageBuilder newInstance() {
            return new PageBuilder();
        }

        /**
         * Set text field to a specified value
         *
         * @param locator - locator to locate text field element
         * @param text    - text to set
         * @return PageBuilder
         */
        public PageBuilder setText(By locator, String text) {
            if (Control.isTextFieldEnabled(locator)) {
                getDriver().findElement(locator).clear();
                getDriver().findElement(locator).sendKeys(text);
            } else {
                logger.error("text field {} not editable",locator.toString() );
                throw new ElementNotSelectableException("Text field can not be edited");
            }
            return this;
        }

        /**
         * @param locator search text field locator
         * @param text    - text to be searched
         * @return - PageBuilder
         */
        public PageBuilder searchTextField(By locator, String text) {
            if (Control.isTextFieldEnabled(locator)) {
                getDriver().findElement(locator).clear();
                getDriver().findElement(locator).sendKeys(text);
            } else {
                logger.error("text field {} not enabled",locator.toString() );
                throw new ElementNotSelectableException("Text field can not be edited");
            }
            return this;
        }

        public void go(String url) {
            getDriver().get(url);
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
                    logger.error("element null");
                    throw new NullPointerException("Element null");
                }

            } else {
                logger.error("element {} not clickable",locator.toString() );
                throw new ElementNotInteractableException("button neither not Displayed, not Enabled" + locator.toString());
            }
            return this;
        }

        public PageBuilder selectWebElement(By locator) {
            if (Control.isWebElementClickable(locator)) {
                getDriver().findElement(locator).click();
            } else {
                logger.error("element {} not not displayed and not enabled",locator.toString() );
                throw new ElementNotInteractableException("Element not Displayed and not enabled");
            }
            return this;
        }

        //Counts
        public static List<WebElement> getClickableElementsByLocator(By locator) {
            List<WebElement> webElement = Objects.requireNonNull(Control.waitOnElementsPresent(locator)).stream()
                    .filter(item -> item.isDisplayed())
                    .filter(item -> item.isEnabled())
                    .collect(Collectors.toList());
            return webElement;
        }

        public static int getClickableElementsCountOn(By frameLocator, By locator) {
            return getClickableElementsOnFrame(frameLocator, locator).size();

        }

        public static List<WebElement> getClickableElementsOnFrame(By frameLocator, By locator) {
            try {
                WebElement webElement = Control.waitOnElementPresent(frameLocator);
                List<WebElement> myElements = webElement.findElements(locator)
                        .stream()
                        .filter(item -> item.isDisplayed())
                        .filter(item -> item.isEnabled())
                        .collect(Collectors.toList());
                return myElements;
            } catch (NullPointerException e) {
                logger.error("Exception occurred:  {} ",e.getStackTrace());
            }
           return null;
        }

        public static List<String> getSelectOptions(By locator) {
            try {
                WebElement webElement = Control.waitOnElementPresent(locator);
                List<String> selectText = (new Select(webElement)).getOptions()
                        .stream()
                        .map(item -> item.getText())
                        .collect(Collectors.toList());
                return selectText;
            }catch (NullPointerException e) {
                logger.error("Exception occured {}", e.getStackTrace());
            }
            return null;
        }

        public static List<WebElement> getTableElements(By locator) {
            return Control.waitOnElementsPresent(locator);
        }

        //Alert functions
        public PageBuilder acceptAlert() {
            try {
                getDriver().switchTo().alert().accept();
            } catch (NoAlertPresentException e) {
                logger.error("Exception occurred:  {} ", e.getStackTrace());
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
            return getDriver().getWindowHandles();
        }

        //Frame Functions
        public PageBuilder moveToFrame(WebElement window) {
            try {
                getDriver().switchTo().frame(window);
            } catch (Exception e) {
                logger.error("Exception occurred:  {} ", e.getStackTrace());
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

    public String getTitle() {
        return getDriver().getTitle();
    }
}