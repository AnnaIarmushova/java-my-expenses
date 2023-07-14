package tests;

import Utils.Utils;
import model.ExpensesPage;
import model.LoginPage;
import model.MainPage;
import model.RegistrationPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import static org.testng.Assert.assertEquals;

public class ExpensesTest extends BaseTest {

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
    public void loginPageButtonTest() {

        MainPage mainPage = new MainPage(getDriver());

        mainPage.getSignInButton().click();

        getWait3().until(ExpectedConditions.urlToBe("https://my-expenses-three.vercel.app/login"));

        LoginPage loginPage = new LoginPage(getDriver());

        Assert.assertEquals(loginPage.getLoginPageTitle().getText(), "LOGIN PAGE");
    }

    @Test
    public void SignUpTest() {

        Utils utils = new Utils();
        utils.setEmail("@gmail.com");
        String email = utils.getEmail();
        String password = "password";

        MainPage mainPage = new MainPage(getDriver());

        mainPage.getSignUpButton().click();

        getWait3().until(ExpectedConditions.urlToBe("https://my-expenses-three.vercel.app/registration"));

        RegistrationPage registrationPage = new RegistrationPage(getDriver());

        registrationPage.getRegEmailField().click();
        registrationPage.getRegEmailField().sendKeys(email);

        registrationPage.getRegPasswordField().click();
        registrationPage.getRegPasswordField().sendKeys(password);

        registrationPage.getRegistrationPageSignUpButton().click();

        ExpensesPage expensesPage = new ExpensesPage(getDriver());

        assertEquals(expensesPage.getExpensesTitle().getText(), "EXPENSES");

        assertEquals(expensesPage.getUserEmail().getText(), email);
    }

    @Test
    public void SignInTest() {

        MainPage mainPage = new MainPage(getDriver());

        mainPage.getSignInButton().click();

        getWait3().until(ExpectedConditions.urlToBe("https://my-expenses-three.vercel.app/login"));

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.getLogEmailField().click();
        loginPage.getLogEmailField().sendKeys("annaiarm345@gmail.com");

        loginPage.getLogPasswordField().click();
        loginPage.getLogPasswordField().sendKeys("Password345");

        loginPage.getLogInButton().click();
    }

    @Test
    public void AddExpensesTest() {

        MainPage mainPage = new MainPage(getDriver());

        mainPage.getSignInButton().click();

        getWait3().until(ExpectedConditions.urlToBe("https://my-expenses-three.vercel.app/login"));

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.getLogEmailField().click();
        loginPage.getLogEmailField().sendKeys("annaiarm345@gmail.com");

        loginPage.getLogPasswordField().click();
        loginPage.getLogPasswordField().sendKeys("Password345");

        loginPage.getLogInButton().click();

        ExpensesPage expensesPage = new ExpensesPage(getDriver());

        expensesPage.getTitleOfExpense().click();
        expensesPage.getTitleOfExpense().sendKeys("cinema");

        expensesPage.getExpenseAmount().click();
        expensesPage.getExpenseAmount().sendKeys("20");

        expensesPage.getExpenseCategory().click();

        expensesPage.getExpenseCategoryEntertainment().click();

        expensesPage.getExpenseCreateButton().click();

        getDriver().get("https://my-expenses-three.vercel.app/");
        getDriver().navigate().refresh();

        expensesPage.getListElements();

        assertEquals(expensesPage.getItemDescription().getText(), "cinema");
        assertEquals(expensesPage.getItemAmount().getText(), "20");
    }
}

