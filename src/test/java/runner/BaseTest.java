package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    private WebDriverWait wait3;
    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(chromeOptions);

        getDriver().get("https://my-expenses-three.vercel.app/");
    }

    @AfterMethod
    protected void afterMethod()  {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait3() {
        return  wait3 = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
    }
}
