package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class MainPageTest extends BaseTest {

    @Test
    public void pageTitleTest() {
        getDriver().get("https://my-expenses-three.vercel.app/");

        WebElement pageTitle = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div[1]/h1"));
        assertEquals(pageTitle.getText(), "MY EXPENSES");
    }

    @Test
    public void signInButtonTest() {
        getDriver().get("https://my-expenses-three.vercel.app/");

        WebElement navigation = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[1]"));
        WebElement signInButton = navigation.findElement(By.cssSelector("a[href=\"/login\"]"));
        assertEquals(signInButton.getText(), "Sign in");
    }

    @Test
    public void loginPageButtonTest() {
        getDriver().get("https://my-expenses-three.vercel.app/");

        WebElement signInButton = getDriver().findElement(By.cssSelector("a[href=\"/login\"]"));
        signInButton.click();

        WebElement loginPageButton = getWait3().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1:not([data-test=\"title\"])")));
        assertEquals(loginPageButton.getText(), "LOGIN PAGE");
    }
    }

