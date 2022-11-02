package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookdepositoryHomePage extends BaseHelper
{
    WebDriver driver;
    public BookdepositoryHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "searchTerm")
    WebElement searchField;
    @FindBy(className = "header-search-btn")
    WebElement searchButton;
    @FindBy(className = "advanced-search")
    WebElement advancedSearchButton;

    private void navigateToHomepage(String url)
    {
        driver.get(url);
    }

    private void insertSearchTerm(String searchTerm)
    {
        wdWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(searchTerm);
    }

    private void clickOnSearchButton()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    private void clickOnAdvancedSearchButton()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(advancedSearchButton));
        advancedSearchButton.click();
    }

    public void searchTest(String url, String searchTerm)
    {
        navigateToHomepage(url);
        insertSearchTerm(searchTerm);
        clickOnSearchButton();
    }

    public void advancedSearchTest(String url)
    {
        navigateToHomepage(url);
        clickOnAdvancedSearchButton();
    }
}
