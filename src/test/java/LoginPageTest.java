import base.ExtendsTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


@DisplayName("Тесты страницы логина")
public class LoginPageTest extends ExtendsTest {

    @Test
    @DisplayName("Авторизуюсь через кнопку Войти в аккаунт")
    @Description("Авторизовался через кнопку Войти в аккаунт на главной странице")
    public void loginWithMainPagePositiveTest() {
        mainPage.open();
        mainPage.pressButtonLogin()
                .enterEmail(VALID_EMAIL)
                .enterPassword(VALID_PASSWORD)
                .pressButtonLogin()
                .checkEnabledButtonMakeOrder();
    }

    @Test
    @DisplayName("Авторизуюсь через кнопку Личный кабинет")
    @Description("Нажимаю кнопку Личный кабинет на главной странице и авторизуюсь на форме")
    public void loginWithMainPageButtonPersonAccountPositiveTest() {
        mainPage.open();
        mainPage.pressButtonPersonalAccount()
                .enterEmail(VALID_EMAIL)
                .enterPassword(VALID_PASSWORD)
                .pressButtonLogin()
                .checkEnabledButtonMakeOrder();
    }

    @Test
    @DisplayName("Авторизуюсь с формы регистрации")
    @Description("Авторизовался через кнопку Войти в аккаунт на странице восстановления пароля")
    public void loginWitRegistrationPagePositiveTest() {
        registrationPage.open();
        registrationPage.pressButtonLogin()
                .enterEmail(VALID_EMAIL)
                .enterPassword(VALID_PASSWORD)
                .pressButtonLogin()
                .checkEnabledButtonMakeOrder();
    }

    @Test
    @DisplayName("Авторизуюсь с формы восстановления пароля ")
    @Description("Авторизовался через кнопку Войти в аккаунт на странице восстановления пароля")
    public void loginWithForgotPagePositiveTest() {
        forgotPasswordPage.open();
        forgotPasswordPage.pressButtonLogin()
                .enterEmail(VALID_EMAIL)
                .enterPassword(VALID_PASSWORD)
                .pressButtonLogin()
                .checkEnabledButtonMakeOrder();
    }
}
