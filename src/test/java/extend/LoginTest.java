package extend;

import extend.basic.Driver;
import extend.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LoginTest extends BaseTest {
    @ParameterizedTest
    @DisplayName("Login with registered user")
    @CsvFileSource(resources = "/login-test.csv", numLinesToSkip = 1)
    public void loginTest(String userName, String userPassword) {
        Assertions.assertNotNull(userName);
        Assertions.assertNotNull(userPassword);
        LoginPage.SignIn(userName, userPassword);
    }
}
