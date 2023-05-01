package extensions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private static final String PROPERTY = "WebDriver";

    private static org.openqa.selenium.WebDriver driver = null;

    static {
        Properties properties = new Properties();
        try (FileReader f = new FileReader("src/test/resources/browser.properties")) {
            properties.load(f);
            System.setProperty(PROPERTY, properties.getProperty(PROPERTY));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private WebDriverFactory() {
    }

    public static org.openqa.selenium.WebDriver getInstance() {
        if (driver == null) {
            if ("firefox".equals(System.getProperty(PROPERTY))) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


    public static void closeInstance() {
        driver.quit();
        driver = null;
    }
}
