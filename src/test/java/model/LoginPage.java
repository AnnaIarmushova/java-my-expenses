package model;

import model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final WebElement loginPageTitle;

    private final WebElement logEmailField;

    private final WebElement logPasswordField;

    private final WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.loginPageTitle = driver.findElement(By.cssSelector("[data-test=\"title-login-page\"]"));
        this.logEmailField = driver.findElement(By.cssSelector("[type=\"email\"]"));
        this.logPasswordField = driver.findElement(By.cssSelector("[type=\"password\"]"));
        this.logInButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
    }

    public WebElement getLoginPageTitle() {
        return loginPageTitle;
    }

    public WebElement getLogEmailField() {
        return logEmailField;
    }

    public WebElement getLogPasswordField() {
        return logPasswordField;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }

    public  LoginPage loginPageTitle() {
        getWait3().until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[data-test=\"title-login-page\"]")));
        return this;
    }

    public LoginPage logEmailField() {
        getDriver().findElement(By.cssSelector("[type=\"email\"]"));
        return this;
    }

    public LoginPage logPasswordField() {
        getDriver().findElement(By.cssSelector("[type=\"password\"]"));
        return this;
    }

    public LoginPage logInButton() {
        getDriver().findElement(By.cssSelector("[type=\"submit\"]"));
        return this;
    }
}
