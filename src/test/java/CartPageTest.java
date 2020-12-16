import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CartPageTest {

    WebDriver driver;
    MainPage mainPage;
    private Object MainPage;

    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe"); // don't forget to change your path to the driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        mainPage = new MainPage(driver);

    }

    @Test
    public void verifyItemPriceInCart() throws Exception {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        ElectronicsPage electronicsPage = new ElectronicsPage(driver);
        ItemPage itemPage = new ItemPage(driver);
        AddedToCartPage addedToCartPage = new AddedToCartPage(driver);

        ElectronicsPage ep = mainPage.clickElectronics(); // main page --> electronics page

        String headerElectronics = electronicsPage.electronicsXpath; // store header element xpath to headerElectronics
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(headerElectronics))); // explicitly wait for the presence of a header element located

        ComputerAndAccessoriesPage cap = ep.clickComputerAndAccessoriesButton(); // electronics page --> computer & accessories page

        ItemPage ip = cap.clickOnItem(); // (3rd item selected for now) select the 4th item on the "computer & accessories"

        // for cases when the "Add to Cart" button not displayed or item Currently unavailable, we can wait here and get some TimeoutException
        String addToCartButtonId = itemPage.addToCartButtonId; // store id of Add to Cart button to addToCartButtonId
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(addToCartButtonId))); // explicitly wait for the presence of a header element located

        String itemPrice = ip.getItemPrice(); // get selected item price and save it to itemPrice variable
        ip.addToCardButton(); // add the item to the cart

        String addedToCartConfirmationMsgXpath = addedToCartPage.addedToCartConfirmationMsgXpath; // store xpath of added to cart confirmation message to addedToCartConfirmationMsgXpath
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addedToCartConfirmationMsgXpath))); // explicitly wait visibility of element with text Added to Cart

        CartPage cp = mainPage.clickCartButton(); // click on Cart button in the top bar navigation menu --> Cart
        String itemCartPrice = cp.getCartItemPrice(); // get actual item price in the Cart and save it to itemCartPrice variable

        Assert.assertEquals(itemPrice, itemCartPrice); // verify that the item’s price is the same as the price displayed in the cart
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
