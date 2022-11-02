package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BookdepositoryYourBasketPage extends BaseHelper
{
    WebDriver driver;
    public BookdepositoryYourBasketPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "quantity")
    WebElement quantitySelect;
    @FindBy(className = "item-total")
    WebElement totalField;
    @FindBy(className = "price")
    WebElement priceField;

    private void selectQuantity(String quantity)
    {
        String total = totalField.getText();
        Select quantitySelector = new Select(quantitySelect);
        quantitySelector.selectByVisibleText(quantity);
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("item-total"), total));
    }

    private double[] pickupData(String quantity)
    {
        double[] data = {1, 2, 3};
        data[0] = Double.parseDouble(quantity);
        data[1] = Double.parseDouble(priceField.getText().replace(',', '.').replace(" €", ""));
        data[2] = Double.parseDouble(totalField.getText().replace(',', '.').replace(" €", ""));
        return data;
    }

    public double[] quantityTest(String quantity)
    {
        selectQuantity(quantity);
        return pickupData(quantity);
    }
}
