package extend.pages;

import extend.basic.Page;
import org.openqa.selenium.By;

public class LoginPage extends Page {
    private static By userNameField=By.id("identifierId");
    private static By userPasswordField=By.id("password");
    private static By nextNameButton=By.xpath("//*[@id=\"identifierNext\"]");
    private static By nextPasswordButton=By.xpath("//*[@id=\"passwordNext\"]");

    public static void SignIn(String userName, String userPasswd){
        Page.PageBuilder.newInstance().setText(userNameField,userName).selectWebElement(nextNameButton);
        Page.PageBuilder.newInstance().setText(userPasswordField,userPasswd).selectWebElement(nextPasswordButton);

    }
    public static void go(String url){
        Page.PageBuilder.newInstance().go(url);
    }
}
