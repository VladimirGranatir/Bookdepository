package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookdepositorySearchPage extends BaseHelper
{
    WebDriver driver;
    public BookdepositorySearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "content-block")
    WebElement resultsContainer;
    @FindBy(name = "price")
    WebElement priceSelect;
    @FindBy(className = "btn-primary")
    WebElement refineResultsButton;
    @FindBy(id = "search-info")
    WebElement resultsNumber;
    @FindBy(className = "continue-to-basket")
    WebElement basketCheckoutButton;

    public WebElement pickupResults()
    {
        wdWait.until(ExpectedConditions.visibilityOf(resultsContainer));
        return resultsContainer;
    }

    private void selectPriceRange(String priceRange)
    {
        wdWait.until(ExpectedConditions.visibilityOf(priceSelect));
        Select priceSelector = new Select(priceSelect);
        priceSelector.selectByVisibleText(priceRange);
    }

    private void clickOnRefineResults()
    {
        String resultsInfo = resultsNumber.getText();
        js.executeScript("arguments[0].scrollIntoView();", refineResultsButton);
        wdWait.until(ExpectedConditions.elementToBeClickable(refineResultsButton));
        refineResultsButton.click();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("search-info"), resultsInfo));
    }

    private void clickOnNthAddToBasket(int serialNumber)
    {
        List<WebElement> listOfBooks = pickupResults().findElements(By.className("book-item"));
        listOfBooks.get(serialNumber - 1).findElement(By.className("add-to-basket")).click();
    }

    private void clickOnBasketCheckout()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(basketCheckoutButton));
        basketCheckoutButton.click();
    }

    public WebElement refineSearchTest(String priceRange)
    {
        selectPriceRange(priceRange);
        clickOnRefineResults();
        return pickupResults();
    }

    public void selectBookTest(int serialNumber)
    {
        clickOnNthAddToBasket(serialNumber);
        clickOnBasketCheckout();
    }
}
