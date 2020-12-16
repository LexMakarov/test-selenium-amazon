import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {

    WebDriver driver;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemPriceBy = By.xpath("//span[@id='priceblock_ourprice']");
    private By addToCartButtonBy = By.id("add-to-cart-button");
    public String addToCartButtonId = "add-to-cart-button";


    public String getItemPrice (){
        return driver.findElement(itemPriceBy).getText();
    }

    public ItemPage addToCardButton(){
        driver.findElement(addToCartButtonBy).click();
        return this;
    }

}
