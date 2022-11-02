package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BookdepositoryHomePage;
import pages.BookdepositorySearchPage;

import java.util.List;

public class BookdepositorySearchFunctionalityTest extends BaseTest
{
    @Test
    public void searchFunctionalityTest() throws InterruptedException
    {
        String url = "https://www.bookdepository.com/";
        String searchTerm = "Frankenstein";

        BookdepositoryHomePage homePage = new BookdepositoryHomePage(driver);
        homePage.searchTest(url, searchTerm);

        BookdepositorySearchPage searchPage = new BookdepositorySearchPage(driver);
        List<WebElement> listResults = searchPage.pickupResults().findElements(By.className("book-item"));

        for(WebElement book : listResults)
        {
            Assert.assertTrue("Title of book do not contain search term.", book.findElement(By.tagName("h3")).getText().toLowerCase().contains(searchTerm.toLowerCase()));
        }

        Thread.sleep(5000);
    }
}
