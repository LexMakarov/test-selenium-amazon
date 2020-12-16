import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectronicsPage {

    WebDriver driver;

    public ElectronicsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By computerAndAccessoriesBy = By.cssSelector("img[alt='Cell Phones & Accessories']");
    public String electronicsXpath = "//h1/b";

    public ComputerAndAccessoriesPage clickComputerAndAccessoriesButton(){
        driver.findElement(computerAndAccessoriesBy).click();
        return new ComputerAndAccessoriesPage(driver);
    }



}
