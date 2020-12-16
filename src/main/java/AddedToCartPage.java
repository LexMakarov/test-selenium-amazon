import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddedToCartPage {

    WebDriver driver;

    public AddedToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addedToCartConfirmationMsgBy = By.xpath("//h1[contains(text(), 'Added to Cart')]");
    public String addedToCartConfirmationMsgXpath = "//h1[contains(text(), 'Added to Cart')]";

}
