package tests;

import model.MainPage;
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

        MainPage mainPage = new MainPage(getDriver());

        WebElement title = mainPage.getPageTitle();

        Assert.assertEquals(title.getText(),"MY EXPENSES");
    }

    @Test
    public void signInButtonTest() {

        MainPage mainPage = new MainPage(getDriver());

        Assert.assertEquals(mainPage.getSignInButton().getText(), "Sign in");
    }

    @Test
    public void loginPageButtonTest()  {

        MainPage mainPage = new MainPage(getDriver());

        mainPage.signInButtonClick();

        WebElement title = getWait3().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[data-test=\"loginPageTitle\"]")));

        Assert.assertEquals(title.getText(), "LOGIN PAGE");
    }
}

