package page_objects;

import config.AppConfig;
import extensions.WebDriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IncorrectPassword {
    private final By buttonLogin = By.linkText("Войти");
    private final WebDriver driver = WebDriverFactory.getInstance();

    @Step("Открыть страницу")
    public void open() {
        driver.get(AppConfig.FORGOT);
    }

    @Step("Нажать кнопку Войти на странице восстановления пароля")
    public LoginPage pressButtonLogin() {
        driver.findElement(buttonLogin).click();
        return new LoginPage();
    }
}
