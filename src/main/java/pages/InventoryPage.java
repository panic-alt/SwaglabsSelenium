package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{

    private final By title = By.className("title");
    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By backpackItem = By.id("item_4_title_link");
    private final By largeItem = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private final By backToProducts = By.id("back-to-products");
    private final By backpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By tshirtButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By lightButton = By.id("add-to-cart-sauce-labs-bike-light");
    private final By dropdownList = By.className("product_sort_container");
    private final By shoppingCart = By.id("shopping_cart_container");
    private final By removeLightButton = By.id("remove-sauce-labs-bike-light");
    private final By checkoutButton = By.id("checkout");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By itemTotal = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]");
    private final By tax = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]");
    private final By total = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private final By checkoutComplete = By.id("checkout_complete_container");
    private final By finishButton = By.id("finish");
    public final String backpackText = getsBackpackText();


    public InventoryPage(WebDriver driver) {

        super(driver);
    }

    public void continues() {

        driver.findElement(continueButton).click();

    }

    public void fillCheckout() {

        driver.findElement(firstNameField).sendKeys("Test first name");
        driver.findElement(lastNameField).sendKeys("Test last name");
        driver.findElement(postalCodeField).sendKeys("0000");

    }

    public void checkout() {

        driver.findElement(checkoutButton).click();

    }

    public void removesLight() {

        driver.findElement(removeLightButton).click();

    }

    public void addsTshirt() {

        driver.findElement(tshirtButton).click();

    }

    public void addsBackpack() {

        driver.findElement(backpackButton).click();

    }

    public void addsLight() {

        driver.findElement(lightButton).click();

    }

    public void toShoppingCart() {

        driver.findElement(shoppingCart).click();

    }

    public int checkShoppingCart() {

        String qItems = driver.findElement(shoppingCart).getText();
        return Integer.parseInt(qItems);
    }

    public boolean validatePage() {

        return driver.findElement(burgerMenu).isDisplayed();

    }

    public String getsBackpackText() {

        return driver.findElement(backpackItem).getText();

    }

    public void selectsItem() {

        driver.findElement(backpackItem).click();

    }

    public void selectsOrder() {


        WebElement dropDown = driver.findElement(dropdownList);

        Select select_order = new Select(dropDown);

        select_order.selectByValue("lohi");


    }

    public String getsLargeItemText() {

        return driver.findElement(largeItem).getText();
    }

    public void goesBackToInventory() {

        driver.findElement(backToProducts).click();

    }

    public void logout() {
        driver.findElement(burgerMenu).click();
        driver.findElement(logoutButton).click();
    }

    public boolean calculatesTotal() {

        String itemTotalText = driver.findElement(itemTotal).getText();
        int itemTotalInt = getsAmount(itemTotalText);

        String taxTotal = driver.findElement(tax).getText();
        int taxInt = getsAmount(taxTotal);

        String totalText = driver.findElement(total).getText();
        int totalInt = getsAmount(totalText);

        return itemTotalInt + taxInt == totalInt;

    }
    
    public int getsAmount(String amount) {
        String stringNumbers= amount.replaceAll("[^0-9]", "");
        return Integer.parseInt(stringNumbers);
    }

    public boolean checksComplete() {

        return driver.findElement(checkoutComplete).isDisplayed();

    }

    public void finishCheckout() {

        driver.findElement(finishButton).click();

    }

}
