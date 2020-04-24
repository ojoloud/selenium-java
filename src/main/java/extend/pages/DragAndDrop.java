package extend.pages;

import extend.basic.Control;
import extend.basic.Driver;
import extend.basic.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop extends Page {

    public static By dragElement = By.id("draggable");
    public static By frame = By.cssSelector("iframe.demo-frame");
    public static By dragInTo = By.id("droppable");

    public static void dragAndDrop(By locator1, By locator2) {
        Page.PageBuilder.newInstance().moveToFrame((Driver.getDriver().findElement(frame)));
        WebElement elementToBeDropped = Control.waitOnElementPresent(locator1);
        WebElement elementDropInto = Control.waitOnElementPresent(locator2);
        Actions advanceActions= new Actions(Driver.getDriver());
        if (Control.isWebElementClickable(locator1)) {
            advanceActions.moveToElement(elementToBeDropped);
            advanceActions.click(elementToBeDropped);
            advanceActions.dragAndDrop(elementToBeDropped, elementDropInto).build().perform();
        } else {
            throw new ElementNotInteractableException("Drag and Drop Element not interactable");
        }
    }
}
