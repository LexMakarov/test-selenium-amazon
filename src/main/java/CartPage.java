import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemCartPriceBy = By.xpath("//p[@class='a-spacing-small']/span[1]");

    public String getCartItemPrice (){
        return driver.findElement(itemCartPriceBy).getText();
    }

}
