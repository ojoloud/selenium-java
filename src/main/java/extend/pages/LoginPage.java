package extend.pages;

import extend.basic.Page;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends Page {
    private static final By userNameField = By.id("identifierId");
    private static final By userPasswordField = By.id("password");
    private static final By nextNameButton = By.xpath("//*[@id=\"identifierNext\"]");
    private static final By nextPasswordButton = By.xpath("//*[@id=\"passwordNext\"]");
    private static final String PAGE_TITLE = "Inbox";
    public final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public static void SignIn(String userName, String userPasswd) {
        Page.PageBuilder.newInstance()
                .setText(userNameField, userName)
                .selectWebElement(nextNameButton);
        Page.PageBuilder.newInstance()
                .setText(userPasswordField, userPasswd)
                .selectWebElement(nextPasswordButton);
    }

    public static void go(String url) {
        PageBuilder loginPage = Page.PageBuilder.newInstance();
        loginPage.go(url);
        Assertions.assertTrue(Page.PageBuilder.getPageTitle()
                .contains(PAGE_TITLE), "Page Title" + PAGE_TITLE + "not present");
    }
}
