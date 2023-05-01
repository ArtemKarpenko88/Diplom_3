package base;

import extensions.WebDriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import page_objects.*;


public class ExtendsTest {
    public static final String VALID_NAME = "ArtemKarpenko";
    public static final String VALID_EMAIL = "ArtemKarpenko@yandex.ru";
    public static final String VALID_PASSWORD = "123456";
    public static String randomEmail = RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru";
    public static String randomCorrectPassword = RandomStringUtils.randomAlphanumeric(10);
    public static String randomIncorrectPassword = RandomStringUtils.randomAlphanumeric(3);
    protected final IncorrectPassword forgotPasswordPage = new IncorrectPassword();
    protected final LoginPage loginPage = new LoginPage();
    protected final MainPage mainPage = new MainPage();
    protected final PageMyAccount personalAccountPage = new PageMyAccount();
    protected final RegistrationPage registrationPage = new RegistrationPage();

    @After
    public void cleanUp() {
        WebDriverFactory.closeInstance();
    }
}
