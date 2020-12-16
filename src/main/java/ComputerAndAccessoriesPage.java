import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComputerAndAccessoriesPage {

    WebDriver driver;

    public ComputerAndAccessoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemBy = By.xpath("//div[contains(@class, 's-main-slot s-result-list s-search-results')]//a[@class='a-link-normal a-text-normal']");

    public ItemPage clickOnItem(){

        List<WebElement> listOfItems = driver.findElements(itemBy);
        listOfItems.get(2).click(); // here you can change the Item number
        return new ItemPage(driver);

    }

}
