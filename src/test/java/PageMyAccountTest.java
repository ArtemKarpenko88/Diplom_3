import base.ExtendsTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;


@DisplayName("Тесты страницы личного кабинета")
public class PageMyAccountTest extends ExtendsTest {

    @Before
    @DisplayName("Авторизуюсь под учетной записью")
    public void setupAccount() {
        mainPage.open();
        mainPage.pressButtonLogin().enterEmail(VALID_EMAIL).enterPassword(VALID_PASSWORD).pressButtonLogin();
    }

    @Test
    @DisplayName("Открытие личного кабинета")
    @Description("Проверяю открытие личного кабинета и доступности кнопки Выхода")
    public void openPersonalAccountPositiveTest() {
        mainPage.pressButtonPersonalAccountWithAuth().checkButtonExitEnabled();
    }

    @Test
    @DisplayName("Переход на главную по кнопке Конструктор")
    @Description("Проверяю переход на главную страницу после нажатия на кнопку Конструктор")
    public void openMainPagePressConstructorPositiveTest() {
        mainPage.pressButtonPersonalAccountWithAuth().pressButtonConstructor().checkLogoVisible();
    }

    @Test
    @DisplayName("Переход на главную по нажатию на лого")
    @Description("Проверяю переход на главную страницу после нажатия на кнопку логотипа")
    public void openMainPagePressLogoPositiveTest() {
        mainPage.pressButtonPersonalAccountWithAuth().pressLogo().checkLogoVisible();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверяю переход на страницу Логина после нажатия на кнопку Выхода")
    public void openLoginPagePressButtonExitPositiveTest() {
        mainPage.pressButtonPersonalAccountWithAuth().pressButtonExit().checkVisibleButtonLogin();
    }
}
