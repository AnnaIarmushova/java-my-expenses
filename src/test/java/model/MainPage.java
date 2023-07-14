package model;

import model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private final WebElement pageTitle;

    private final WebElement signInButton;

    private final WebElement signUpButton;


    public MainPage(WebDriver driver) {
        super(driver);
        this.pageTitle = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div[1]/h1"));
        this.signInButton = driver.findElement(By.cssSelector("a[href=\"/login\"]"));
        this.signUpButton = driver.findElement(By.cssSelector("a[href=\"/registration\"]"));
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }


    public MainPage pageTitle() {
        getDriver().findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div[1]/h1"));
        return this;
    }
    public MainPage signInButton() {
        getDriver().findElement(By.cssSelector("a[href=\"/login\"]"));
        return this;
    }
    public MainPage signUpButton() {
        getDriver().findElement(By.cssSelector("a[href=\"/registration\"]"));
        return this;
    }
}
