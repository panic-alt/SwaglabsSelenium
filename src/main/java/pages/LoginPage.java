package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By loginRobot = By.className("bot_column");
    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By errorMessage = By.cssSelector(
            "#login_button_container > div > form > div.error-message-container.error > h3");

    public LoginPage(WebDriver driver){

        super(driver);
    }

     public void performLogin(String username, String password) {

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

    }

    public void open(){
        driver.get("https://www.saucedemo.com");
    }
}
