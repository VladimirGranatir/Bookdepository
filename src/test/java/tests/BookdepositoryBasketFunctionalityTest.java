package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BookdepositoryAdvancedSearchPage;
import pages.BookdepositoryHomePage;
import pages.BookdepositorySearchPage;
import pages.BookdepositoryYourBasketPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookdepositoryBasketFunctionalityTest extends BaseTest
{
    @Test
    public void basketFunctionalityTest() throws InterruptedException
    {
        String url = "https://www.bookdepository.com/";
        String searchTitle = "Timaeus";
        String searchAuthor = "Plato";
        int serialNumber = 8;
        String quantity = "4";

        BookdepositoryHomePage homePage = new BookdepositoryHomePage(driver);
        homePage.advancedSearchTest(url);

        BookdepositoryAdvancedSearchPage advancedSearchPage = new BookdepositoryAdvancedSearchPage(driver);
        advancedSearchPage.advancedTitleTest(searchTitle, searchAuthor);

        BookdepositorySearchPage searchPage = new BookdepositorySearchPage(driver);
        searchPage.selectBookTest(serialNumber);

        BookdepositoryYourBasketPage yourBasketPage = new BookdepositoryYourBasketPage(driver);
        double[] data = yourBasketPage.quantityTest(quantity);

        Assert.assertTrue("Total value is not product of quantity and unit price! ",data[0] * data[1] == data[2]);

        Thread.sleep(5000);
    }
}
