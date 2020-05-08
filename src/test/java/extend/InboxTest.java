package extend;

import extend.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

public class InboxTest extends BaseTest {

    @BeforeEach
    @ParameterizedTest
    @DisplayName("Login to Inbox")
    @CsvFileSource(resources = "/inbox-test.csv", numLinesToSkip = 1)
    @MethodSource("randomSubjectLineProvider")
    void initTest(String userName, String userPasswd, String randomSubjectLineProvider) {
        LoginPage.SignIn(userName, userPasswd);
    }

    @ParameterizedTest
    @DisplayName("Generate Email")
    @MethodSource("randomSubjectLineProvider")
    void generateEmailtest(String randomSubjectLineProvider) {
    }
    static Stream<String> randomSubjectLineProvider() {
        return Stream.of(new Random(100) + "subject line");
    }

}
