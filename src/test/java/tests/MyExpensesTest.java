package tests;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class MyExpensesTest extends BaseTest {

    @Test
    public void pageTitleTest() {
        getDriver().get("https://my-expenses-three.vercel.app/");

        WebElement pageTitle = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div[1]/h1"));
        assertEquals(pageTitle.getText(), "MY EXPENSES");
    }

    @Test
    public void signInButtonTest() {
        getDriver().get("https://my-expenses-three.vercel.app/");

        WebElement signInButton = getDriver().findElement(By.cssSelector("a[href=\"/login\"]"));
        assertEquals(signInButton.getText(), "Sign in");
    }

    @Test
    public void loginPageTitleTest() {
        getDriver().get("https://my-expenses-three.vercel.app/");

        WebElement signInButton = getDriver().findElement(By.cssSelector("a[href=\"/login\"]"));
        signInButton.click();

        WebElement loginPageTitle = getWait3().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test=\"title-login-page\"]")));
        assertEquals(loginPageTitle.getText(), "LOGIN PAGE");
    }

    @Test
    public void SignUpTest() {

        Utils utils = new Utils();
        utils.setEmail("@gmail.com");
        String email = utils.getEmail();
        String password = "password";

        getDriver().get("https://my-expenses-three.vercel.app/");

        WebElement signUpButton = getDriver().findElement(By.cssSelector("a[href=\"/registration\"]"));
        signUpButton.click();

        getWait3().until(ExpectedConditions.urlToBe("https://my-expenses-three.vercel.app/registration"));

        WebElement emailField = getDriver().findElement(By.cssSelector("[type=\"email\"]"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField = getDriver().findElement(By.cssSelector("[type=\"password\"]"));
        passwordField.click();
        passwordField.sendKeys(password);

        getDriver().findElement(By.cssSelector("[type=\"submit\"]")).click();

        WebElement expensesTitle = getWait3().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test=\"title-account-page\"]")));

        assertEquals(expensesTitle.getText(), "EXPENSES");

        WebElement userEmail = getDriver().findElement(By.cssSelector("[data-test=\"user-email\"]"));
        assertEquals(userEmail.getText(), email);
    }

    @Test
    public void SignInTest() {
        getDriver().get("https://my-expenses-three.vercel.app/");

        WebElement signInButton = getDriver().findElement(By.cssSelector("a[href=\"/login\"]"));
        signInButton.click();

        getWait3().until(ExpectedConditions.urlToBe("https://my-expenses-three.vercel.app/login"));

        WebElement emailField = getDriver().findElement(By.cssSelector("[type=\"email\"]"));
        emailField.click();
        emailField.sendKeys("annaiarm345@gmail.com");

        WebElement passwordField = getDriver().findElement(By.cssSelector("[type=\"password\"]"));
        passwordField.click();
        passwordField.sendKeys("Password345");

        getDriver().findElement(By.cssSelector("[type=\"submit\"]")).click();
    }

    @Test
    public void AddExpensesTest() {
        getDriver().get("https://my-expenses-three.vercel.app/");

        WebElement signInButton = getDriver().findElement(By.cssSelector("a[href=\"/login\"]"));
        signInButton.click();

        getWait3().until(ExpectedConditions.urlToBe("https://my-expenses-three.vercel.app/login"));

        WebElement emailField = getDriver().findElement(By.cssSelector("[type=\"email\"]"));
        emailField.click();
        emailField.sendKeys("annaiarm345@gmail.com");

        WebElement passwordField = getDriver().findElement(By.cssSelector("[type=\"password\"]"));
        passwordField.click();
        passwordField.sendKeys("Password345");

        getDriver().findElement(By.cssSelector("[type=\"submit\"]")).click();

        WebElement expenseTitle = getWait3().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"text\"]")));

        expenseTitle.click();
        expenseTitle.sendKeys("cinema");

        WebElement expenseAmount = getDriver().findElement(By.cssSelector("[type=\"number\"]"));
        expenseAmount.click();
        expenseAmount.sendKeys("20");

        WebElement expenseCategory = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[3]/form/select"));
        expenseCategory.click();

        getDriver().findElement(By.cssSelector("[value=\"4\"]")).click();

        getDriver().findElement(By.cssSelector("[type=\"submit\"]")).click();

        getDriver().get("https://my-expenses-three.vercel.app/");
        getDriver().navigate().refresh();

        getWait3().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test=\"item\"]")));

        List<WebElement> listElements = getDriver().findElements(By.cssSelector("[data-test=\"item\"]"));
        WebElement lastItem = listElements.get((listElements.size() - 1));

        WebElement itemDescription = lastItem.findElement(By.cssSelector("[data-test=\"description\"]"));
        WebElement itemAmount = lastItem.findElement(By.cssSelector("[data-test=\"amount\"]"));
        assertEquals(itemDescription.getText(), "cinema");
        assertEquals(itemAmount.getText(), "20");
    }
}

