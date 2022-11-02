package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BookdepositoryAdvancedSearchPage;
import pages.BookdepositoryHomePage;
import pages.BookdepositorySearchPage;

import java.util.List;

public class BookdepositoryPriceRangeTest extends BaseTest
{
    @Test
    public void priceRangeTest() throws InterruptedException
    {
        String url = "https://www.bookdepository.com/";
        String searchAuthor = "Harald Haarmann";
        String language = "English";
        String priceRange = "30 € +";

        BookdepositoryHomePage homePage = new BookdepositoryHomePage(driver);
        homePage.advancedSearchTest(url);

        BookdepositoryAdvancedSearchPage advancedSearchPage = new BookdepositoryAdvancedSearchPage(driver);
        advancedSearchPage.advancedSearchTest(searchAuthor, language);

        BookdepositorySearchPage searchPage = new BookdepositorySearchPage(driver);
        List<WebElement> listResults = searchPage.refineSearchTest(priceRange).findElements(By.className("book-item"));

        for(WebElement book : listResults)
        {
            String priceFull = book.findElement(By.className("price")).findElement(By.tagName("span")).getText();
            double price = Double.parseDouble(priceFull.substring(0, priceFull.length()-2).replace(',', '.'));
            Assert.assertTrue("Price of book is not in price range.", !(price<30.00));
        }

        Thread.sleep(5000);
    }
}
