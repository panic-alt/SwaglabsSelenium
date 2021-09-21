package steps;

import com.gargoylesoftware.htmlunit.Page;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import resources.PageValidationError;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    private WebDriver driver;
    LoginPage loginPage;



    @Given("the user is in the login page")
    public void the_user_is_in_the_login_page() {

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/pabni/IdeaProjects/Swaglabs-Selenium/drivers/Chrome/windows_chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");


    }

    @When("the user logs in with (.*) and (.*)")
    public void the_user_logs_in_with_and(String  username, String password) {

        loginPage.performLogin(username, password);

    }

    @Then("reaches the inventory page")
    public void reaches_the_inventory_page() {

        try {
            boolean burgerMenu = loginPage.checkBurger();
            if (burgerMenu) {
                System.out.println("Page validated");
            } else {
                throw new PageValidationError();
            }
        }catch(PageValidationError e) {
            System.out.println(e.getMessage());
        }
    }
    @Then("logs out")
    public void logs_out() {

        loginPage.logOut();
        try {
            boolean loginRobot = loginPage.checkRobot();
            if (loginRobot) {
                System.out.println("Page validated");
            } else {
                throw new PageValidationError();
            }
        }catch (PageValidationError e) {
            System.out.println(e.getMessage());

        }
        driver.close();
        driver.quit();
    }

}
