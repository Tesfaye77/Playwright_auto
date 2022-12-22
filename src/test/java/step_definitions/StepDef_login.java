package step_definitions;

import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_object.loginPage;


public class StepDef_login {
    loginPage login;
    Playwright playwright = Playwright.create();
    BrowserType chrome = playwright.chromium( );
    Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();


    @Given("i open Ztrain login page")
    public void iOpenZtrainLoginPage() {
        page.navigate("https://ztrain-web.vercel.app/auth/login");
        login = new loginPage(page);
    }

    @When("I'm in the login page")
    public void iMInTheLoginPage() {
    }

    @And("I enter email address {string} and password {string}")
    public void loginIntoTheApplication(String email,String pass ) {
        login.enterEmail(email); login.enterPassword(pass);
    }


    @And("I clicks to the login button")
    public void iClicksToTheLoginButton() {
        login.clickLoginButton();
    }



    @Then("The user is connected with  {string}")
    public void theUserIsConnectedWith(String confirmationLogin) {
        login.saveScreen();
        String confirmation = login.getConfirmationLogin();
        Assert.assertEquals(confirmation,confirmationLogin);
    }

    @Then("Access is denied with the message {string}")
    public void accessIsDeniedWithTheMessage(String failedLogin) {
        login.saveScreen();
        String failed = login.getFailedLogin();
        Assert.assertEquals(failed,failedLogin);
    }

    @Then("Access is denied with {string}")
    public void accessIsDeniedWith(String fail_email) {
        login.saveScreen();
        String fail = login.getFail_email();
        Assert.assertEquals(fail,fail_email);
    }

    @When("I'm in the login page with {string} and password {string}")
    public void iMInTheLoginPageWithAndPassword(String arg0, String arg1) {
        login.enterEmail(arg0);
        login.enterPassword(arg1);
        login.clickLoginButton();
    }

    @And("I clicks to the logout button")
    public void iClicksToTheLogoutButton() {

        login.logoutButton();
    }

    @Then("I'm logout")
    public void iMLogout() {
        login.saveScreen();
        assert page.url().equals("https://ztrain-web.vercel.app/home");
    }
}
