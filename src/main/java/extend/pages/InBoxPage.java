package extend.pages;

import extend.basic.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class InBoxPage extends Page {

    public static final By emailRow = By.xpath("//*[@role='row'");
    public static final By emailColumn = By.xpath("//*[@role='column");
    public final Logger logger = LoggerFactory.getLogger(InBoxPage.class);
    public List<String> getEmailSubjects() {
        try {
            List emailList = new ArrayList();
            List<WebElement> inboxRows = this.getInboxRows();
            for (WebElement row : inboxRows) {
                String emailSubject = row.findElement(emailColumn).getText();
                if (emailList !=null) {
                    emailList.add(emailSubject);
                }
            }
            return emailList;
        } catch (NoSuchElementException e) {
            logger.error("Exception occurred: {} ",e);
        }
        return null;
    }

    public List<WebElement> getInboxRows() {
        return Page.PageBuilder.getTableElements(emailRow);
    }
}
