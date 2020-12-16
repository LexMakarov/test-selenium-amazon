import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By electronicsBy = By.cssSelector("img[alt='Electronics']");
    private By navigationCartButtonBy = By.xpath(".//*[@id='nav-cart']");

    public ElectronicsPage clickElectronics () {
        driver.findElement(electronicsBy).click();
        return new ElectronicsPage(driver);
    }

    public CartPage clickCartButton () {
        driver.findElement(navigationCartButtonBy).click();
        return new CartPage(driver);
    }

}
