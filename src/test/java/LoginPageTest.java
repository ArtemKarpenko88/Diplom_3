import api.User;
import api.UserClient;
import api.UserCredentials;
import base.ExtendsTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@DisplayName("Тесты страницы логина")
public class LoginPageTest extends ExtendsTest {
    protected static final User user = ExtendsTest.getRandomUser();

    UserClient userClient;

    @Before
    @DisplayName("Создание тестового клиента")

    public void setupAccount() {
        userClient = new UserClient();
        userClient.createUser(user);

    }

    @Test
    @DisplayName("Авторизуюсь через кнопку Войти в аккаунт")
    @Description("Авторизовался через кнопку Войти в аккаунт на главной странице")
    public void loginWithMainPagePositiveTest() {
        mainPage.open();
        mainPage.pressButtonLogin()
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .pressButtonLogin()
                .checkEnabledButtonMakeOrder();
    }

    @Test
    @DisplayName("Авторизуюсь через кнопку Личный кабинет")
    @Description("Нажимаю кнопку Личный кабинет на главной странице и авторизуюсь на форме")
    public void loginWithMainPageButtonPersonAccountPositiveTest() {
        mainPage.open();
        mainPage.pressButtonPersonalAccount()
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .pressButtonLogin()
                .checkEnabledButtonMakeOrder();
    }

    @Test
    @DisplayName("Авторизуюсь с формы регистрации")
    @Description("Авторизовался через кнопку Войти в аккаунт на странице восстановления пароля")
    public void loginWitRegistrationPagePositiveTest() {
        registrationPage.open();
        registrationPage.pressButtonLogin()
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .pressButtonLogin()
                .checkEnabledButtonMakeOrder();
    }

    @Test
    @DisplayName("Авторизуюсь с формы восстановления пароля ")
    @Description("Авторизовался через кнопку Войти в аккаунт на странице восстановления пароля")
    public void loginWithForgotPagePositiveTest() {
        forgotPasswordPage.open();
        forgotPasswordPage.pressButtonLogin()
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .pressButtonLogin()
                .checkEnabledButtonMakeOrder();
    }

    @After
    public void tearDown() {
        userClient = new UserClient();
        UserCredentials userCredentials = new UserCredentials(user.getEmail(), user.getPassword());
        Response response = userClient.login(userCredentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }

    }
}
