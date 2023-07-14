package model;

import model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    private final WebElement regEmailField;

    private final WebElement regPasswordField;

    private final WebElement registrationPageSignUpButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.regEmailField = driver.findElement(By.cssSelector("[type=\"email\"]"));
        this.regPasswordField = driver.findElement(By.cssSelector("[type=\"password\"]"));
        this.registrationPageSignUpButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
    }

    public WebElement getRegEmailField() {
        return regEmailField;
    }

    public WebElement getRegPasswordField() {
        return regPasswordField;
    }

    public WebElement getRegistrationPageSignUpButton() {
        return registrationPageSignUpButton;
    }

    public RegistrationPage regEmailField() {
        getDriver().findElement(By.cssSelector("[type=\"email\"]"));
        return this;
    }

    public RegistrationPage regPasswordField() {
        getDriver().findElement(By.cssSelector("[type=\"password\"]"));
        return this;
    }

    public RegistrationPage registrationPageSignUpButton() {
        getDriver().findElement(By.cssSelector("[type=\"submit\"]"));
        return this;
    }
}
