package page_objects;

import config.AppConfig;
import extensions.WebDriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageMyAccount {
    By buttonExit = By.xpath(".//button[text()='Выход']");
    By buttonConstructor = By.linkText("Конструктор");
    By logo = By.className("AppHeader_header__logo__2D0X2");

    private final WebDriver driver = WebDriverFactory.getInstance();

    @Step("Открыть страницу")
    public void open() {
        driver.get(AppConfig.PERSON);
    }

    @Step("Проверяю доступность кнопки Выход в личном кабинете")
    public boolean checkButtonExitEnabled() {
        return driver.findElement(buttonExit).isEnabled();
    }

    @Step("Нажимаю на кнопку Выход")
    public LoginPage pressButtonExit() {
        driver.findElement(buttonExit).click();
        return new LoginPage();
    }

    @Step("Нажимаю на кнопку Конструктор из Личного кабинета")
    public MainPage pressButtonConstructor() {
        driver.findElement(buttonConstructor).click();
        return new MainPage();
    }

    @Step("Нажимаю на Лого из Личного кабинета")
    public MainPage pressLogo() {
        driver.findElement(logo).click();
        return new MainPage();
    }
}
