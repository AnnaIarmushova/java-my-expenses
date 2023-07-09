package model;

import model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class MainPage extends BasePage {

    private final WebElement pageTitle;

    private final WebElement signInButton;

    private final WebElement loginPageButton;

    public MainPage(WebDriver driver) {
        super(driver);
        this.pageTitle = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div[1]/h1"));
        this.signInButton = driver.findElement(By.cssSelector("a[href=\"/login\"]"));
        this.loginPageButton = driver.findElement(By.cssSelector("h1[data-test=\"loginPageTitle\"]"));
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getLoginPageButton() {
        return loginPageButton;
    }

    public MainPage signInButton() {
        getDriver().findElement(By.cssSelector("a[href=\"/login\"]"));
        return this;
    }
    public MainPage signInButtonClick() {
        getDriver().findElement(By.cssSelector("a[href=\"/login\"]")).click();
        return this;
    }

    public  LoginPage loginPageButton() {
        getWait3().until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("h1[data-test=\"loginPageTitle\"]")));
        return new LoginPage(getDriver());
    }
}
