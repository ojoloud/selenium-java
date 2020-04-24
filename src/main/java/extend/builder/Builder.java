package extend.builder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

interface Builder {

    void setText(By locator, String text);
    void clickElement(By locator);
    void selectSubMenu(By locator, By locator1);
    Boolean isWebElementSelected(By locator);
    List<WebElement> getClickableElements (By locator);
    List<WebElement> getClickableElementsOnFrame (By frameLocator, By locator);
    void acceptAlert();
    void moveToWindow(String window);
    void moveToFrame(WebElement window);
    void returnContextBack();

}
