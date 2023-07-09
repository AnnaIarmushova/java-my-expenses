package model.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    private final WebDriver driver;

    private WebDriverWait wait3;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    protected WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getWait3() {
        if(wait3 == null) {
            wait3 = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        }
        return wait3;
    }
}
