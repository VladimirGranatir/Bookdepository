package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BookdepositoryAdvancedSearchPage extends BaseHelper
{
    WebDriver driver;
    public BookdepositoryAdvancedSearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "searchAuthor")
    WebElement insertAuthorField;
    @FindBy(name = "searchLang")
    WebElement languageSelect;
    @FindBy(className = "btn-primary")
    WebElement searchButton;
    @FindBy(name = "searchTitle")
    WebElement insertTitleField;

    private void insertAuthor(String searchAuthor)
    {
        wdWait.until(ExpectedConditions.visibilityOf(insertAuthorField));
        insertAuthorField.sendKeys(searchAuthor);
    }

    private void selectLanguage(String language)
    {
        wdWait.until(ExpectedConditions.visibilityOf(languageSelect));
        Select languageSelector = new Select(languageSelect);
        languageSelector.selectByVisibleText(language);
    }

    private void clickOnSearchButton()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    private void insertTitle(String searchTitle)
    {
        wdWait.until(ExpectedConditions.visibilityOf(insertTitleField));
        insertTitleField.sendKeys(searchTitle);
    }

    public void advancedSearchTest(String searchAuthor, String language)
    {
        insertAuthor(searchAuthor);
        selectLanguage(language);
        clickOnSearchButton();
    }

    public void advancedTitleTest(String searchTitle, String searchAuthor)
    {
        insertTitle(searchTitle);
        insertAuthor(searchAuthor);
        clickOnSearchButton();
    }
}
