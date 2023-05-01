package page_objects;

import config.AppConfig;
import extensions.WebDriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    By fieldName = By.xpath(".//fieldset[1]//input");
    By fieldEmail = By.xpath(".//fieldset[2]//input");
    By fieldPassword = By.xpath("//input[@name = 'Пароль']");
    By buttonRegistration = By.xpath("//button[text() = 'Зарегистрироваться']");
    By errorText = By.className("input__error");
    By buttonLogin = By.linkText("Войти");

    private final WebDriver driver = WebDriverFactory.getInstance();

    @Step("Открыть страницу")
    public void open() {
        driver.get(AppConfig.REGISTER);
    }

    @Step("Ввожу данные в поле Имя")
    public RegistrationPage enterName(String name) {
        driver.findElement(fieldName).sendKeys(name);
        return this;
    }

    @Step("Ввожу данные в поле Email")
    public RegistrationPage enterEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
        return this;
    }

    @Step("Ввожу данные в поле Пароль")
    public RegistrationPage enterPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
        return this;
    }

    @Step("Нажимаю кнопку Зарегистрироваться")
    public RegistrationPage pressButtonRegistration() {
        driver.findElement(buttonRegistration).click();
        return this;
    }

    @Step("Проверяю отображение текста ошибки о вводе неправильного пароля")
    public boolean checkErrorMessage() {
        return driver.findElement(errorText).isDisplayed();
    }

    @Step("Нажимаю на кнопку Войти на форме регистрации")
    public LoginPage pressButtonLogin() {
        driver.findElement(buttonLogin).click();
        return new LoginPage();
    }
}
