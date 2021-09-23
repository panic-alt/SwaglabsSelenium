package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;
import resources.ItemQuantityError;
import resources.ItemValidationError;
import resources.PageValidationError;

import java.util.concurrent.TimeUnit;

public class ShoppingSteps {

    private WebDriver driver;
    InventoryPage inventoryPage;
    LoginPage loginPage;


    @Given("The user has logged in with (.*) and (.*)")
    public void the_user_has_logged_in_with_and_(String username, String password) throws PageValidationError {

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/pabni/IdeaProjects/Swaglabs-Selenium/drivers/Chrome/windows_chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");

        boolean loginRobot = loginPage.checkRobot();
        if (!loginRobot) {
            throw new PageValidationError("Page validation error. Could not find element it was looking for.");
        }

        loginPage.performLogin(username, password);
    }

    @When("They order the price from low to high")
    public void they_order_the_price_from_low_to_high() throws PageValidationError {

        inventoryPage = new InventoryPage(driver);

        boolean burgerMenu = inventoryPage.validatePage();
        if (!burgerMenu){
            throw new PageValidationError("Page validation error. Could not find element it was looking for.");
        }

        inventoryPage.selectsOrder();

    }

    @When("Selects an item")
    public void selects_an_item() {

        inventoryPage.selectsItem();


    }

    @When("Visits the item's page")
    public void visits_the_item_s_page() throws ItemValidationError {

        String text = inventoryPage.getsLargeItemText();

        if ( !text.equals(inventoryPage.backpackText) ) {
            throw new ItemValidationError("Item's page does not match item selected in the inventory page");
        }

    }

    @When("goes back")
    public void goes_back() {

        inventoryPage.goesBackToInventory();

    }

    @When("They add things to the shopping cart")
    public void they_add_things_to_the_shopping_cart() {

        inventoryPage.addsTshirt();
        inventoryPage.addsBackpack();
        inventoryPage.addsLight();

    }

    @When("checks the shopping cart")
    public void checks_the_shopping_cart() throws ItemQuantityError {

        int items = inventoryPage.checkShoppingCart();
        if ( items != 3 ) {
            throw new ItemQuantityError("the shopping cart's item count does not match the quantity of items added");
        }
        inventoryPage.toShoppingCart();

    }

    @When("removes an item")
    public void removes_an_item() {

        inventoryPage.removesLight();

    }

    @When("checks out")
    public void checks_out() {

        inventoryPage.checkout();
        inventoryPage.fillCheckout();
        inventoryPage.continues();

    }

    @Then("the total should match the sum of the items plus taxes")
    public void the_total_should_match_the_sum_of_the_items_plus_taxes() {

        boolean total = inventoryPage.calculatesTotal();
        assert total :  "Total does not match items total plus taxes.";

        inventoryPage.finishCheckout();

    }

    @Then("completes the process")
    public void completes_the_process() {
        boolean complete = inventoryPage.checksComplete();
        assert complete : "Could not complete the process.";

        driver.close();
        driver.quit();
    }

}
