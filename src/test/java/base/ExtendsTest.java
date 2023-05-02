package base;

import api.User;

import extensions.WebDriverFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;

import page_objects.*;


public class ExtendsTest {

    public static String randomCorrectPassword = RandomStringUtils.randomAlphanumeric(10);
    public static String randomCorrectName = RandomStringUtils.randomAlphanumeric(7);
    public static String randomIncorrectPassword = RandomStringUtils.randomAlphanumeric(3);
    protected final IncorrectPassword forgotPasswordPage = new IncorrectPassword();
    protected final LoginPage loginPage = new LoginPage();
    protected final MainPage mainPage = new MainPage();
    protected final RegistrationPage registrationPage = new RegistrationPage();


    public static User getRandomUser() {
        String name = randomCorrectName;
        String email = name + "@yandex.ru";
        String password = randomCorrectPassword;

        return new User(email, password, name);
    }


    @After
    public void cleanUp() {
        WebDriverFactory.closeInstance();
    }
}
