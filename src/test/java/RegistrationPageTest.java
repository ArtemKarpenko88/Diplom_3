import api.UserClient;
import api.UserCredentials;
import base.ExtendsTest;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@DisplayName("Тесты страницы регистрации")
public class RegistrationPageTest extends ExtendsTest {
    UserClient userClient;

    protected String name = ExtendsTest.getRandomUser().getName();
    protected String email = ExtendsTest.getRandomUser().getEmail();
    protected String password = ExtendsTest.getRandomUser().getPassword();
    protected String incorrectPassword =randomIncorrectPassword;
    @Before
    @Step("Открываю ссылку на странице регистрации")
    public void setupRegistrationPage() {
        registrationPage.open();
    }


    @Test
    @DisplayName("Регистрирую пользователя с корректными данными")
    @Description("Ввожу рандомные данные почты и пароля с корректной длинной полей")
    public void registrationUserPositiveTest() {
        registrationPage.enterName(name)
                .enterEmail(email)
                .enterPassword(password)
                .pressButtonRegistration();

        loginPage.checkVisibleButtonLogin();


    }

    @Test
    @DisplayName("Регистрирую пользователя с некорректным паролем")
    @Description("Ввожу рандомные данные почты и пароля, а пароль некорректной длинны")
    public void registrationUserNegativeTest() {
        registrationPage.enterName(name)
                .enterEmail(email)
                .enterPassword(incorrectPassword)
                .pressButtonRegistration()
                .checkErrorMessage();
    }
    @After
    public void tearDown(){
        userClient = new UserClient();
        UserCredentials userCredentials = new UserCredentials(email, password);
        Response response = userClient.login(userCredentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }

        UserCredentials userNoValidCredentials = new UserCredentials(email, incorrectPassword);
        Response noValidResponse = userClient.login(userNoValidCredentials);
        if (noValidResponse.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(noValidResponse);
        }
    }

}


