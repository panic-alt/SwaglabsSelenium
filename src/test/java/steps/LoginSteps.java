package steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginSteps {

    @Given("the user is in the login page")
    public void opensLoginPage(){
        LoginPage loginPage = new LoginPage(new ChromeDriver());
        loginPage.open();

    }
}
