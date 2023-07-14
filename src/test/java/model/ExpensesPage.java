package model;

import model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.List;

public class ExpensesPage extends BasePage {

    private final WebElement expensesTitle;

    private final WebElement userEmail;

    private final WebElement titleOfExpense;

    private final WebElement expenseAmount;

    private final WebElement expenseCategory;

    private final WebElement expenseCategoryEntertainment;

    private final WebElement expenseCreateButton;

    private final List<WebElement> listElements;

    private final WebElement lastItem;

    private final WebElement itemDescription;

    private final WebElement itemAmount;


    public ExpensesPage(WebDriver driver) {
        super(driver);
        this.expensesTitle = getWait3().until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[data-test=\"title-account-page\"]")));
        this.userEmail = driver.findElement(By.cssSelector("[data-test=\"user-email\"]"));
        this.titleOfExpense = getWait3().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"text\"]")));
        this.expenseAmount = driver.findElement(By.cssSelector("[type=\"number\"]"));
        this.expenseCategory = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[3]/form/select"));
        this.expenseCategoryEntertainment = getDriver().findElement(By.cssSelector("[value=\"4\"]"));
        this.expenseCreateButton = getDriver().findElement(By.cssSelector("[type=\"submit\"]"));
        this.listElements = Collections.singletonList(getWait3().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test=\"item\"]"))));
        this.lastItem = listElements.get((listElements.size() - 1));
        this.itemDescription = getLastItem().findElement(By.cssSelector("[data-test=\"description\"]"));
        this.itemAmount = getLastItem().findElement(By.cssSelector("[data-test=\"amount\"]"));
    }

    public WebElement getExpensesTitle() {
        return expensesTitle;
    }

    public ExpensesPage expensesTitle() {
        getWait3().until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[data-test=\"title-account-page\"]")));
        return this;
    }
    public WebElement getUserEmail() {
        return userEmail;
    }

    public ExpensesPage userEmail() {
        getDriver().findElement(By.cssSelector("[data-test=\"user-email\"]"));
        return this;
    }

    public WebElement getTitleOfExpense() {
        return titleOfExpense;
    }

    public ExpensesPage titleOfExpense() {
        getWait3().until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[type=\"text\"]")));
        return this;
    }

    public WebElement getExpenseAmount() {
        return expenseAmount;
    }

    public ExpensesPage expenseAmount() {
        getDriver().findElement(By.cssSelector("[type=\"number\"]"));
        return this;
    }

    public WebElement getExpenseCategory() {
        return expenseCategory;
    }

    public ExpensesPage expenseCategory() {
        getDriver().findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[3]/form/select"));
        return this;
    }

    public WebElement getExpenseCategoryEntertainment() {
        return expenseCategoryEntertainment;
    }

    public ExpensesPage expenseCategoryEntertainment() {
        getDriver().findElement(By.cssSelector("[value=\"4\"]"));
        return this;
    }

    public WebElement getExpenseCreateButton() {
        return expenseCreateButton;
    }

    public ExpensesPage expenseCreateButton() {
        getDriver().findElement(By.cssSelector("[type=\"submit\"]"));
        return this;
    }

    public WebElement getListElements() {
        return (WebElement) listElements;
    }

    public ExpensesPage listElements() {
        getWait3().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test=\"item\"]")));
        return this;
    }
    public WebElement getLastItem() {
        return lastItem;
    }
    public ExpensesPage lastItem() {
        listElements.get((listElements.size() - 1));
        return this;
    }

    public WebElement getItemDescription() {
        return itemDescription;
    }

    public ExpensesPage itemDescription() {
        getLastItem().findElement(By.cssSelector("[data-test=\"description\"]"));
        return this;
    }

    public WebElement getItemAmount() {
        return itemAmount;
    }

    public ExpensesPage itemAmount() {
        getLastItem().findElement(By.cssSelector("[data-test=\"amount\"]"));
        return this;
    }
}
