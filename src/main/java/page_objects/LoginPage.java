package page_objects;


import config.AppConfig;
import extensions.WebDriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver = WebDriverFactory.getInstance();
    private final By buttonLogin = By.className("button_button__33qZ0");
    private final By fieldEmail = By.xpath(".//fieldset[1]//input");
    private final By fieldPassword = By.xpath("//input[@name = 'Пароль']");

    @Step("Открыть страницу")
    public void open() {
        driver.get(AppConfig.LOGIN);
    }

    @Step("Проверяю видимость кнопки Войти на форме Логина")
    public boolean checkVisibleButtonLogin() {
        return driver.findElement(buttonLogin).isDisplayed();
    }

    @Step("Нажимаю кнопку Войти на странице Логина")
    public MainPage pressButtonLogin() {
        driver.findElement(buttonLogin).click();
        return new MainPage();
    }

    @Step("Ввожу данные в поле Email")
    public LoginPage enterEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
        return this;
    }

    @Step("Ввожу данные в поле Пароль")
    public LoginPage enterPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
        return this;
    }
}
