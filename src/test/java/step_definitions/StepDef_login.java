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
    Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(true));
    Page page = browser.newPage();


    @Given("i open Ztrain login page")
    public void iOpenZtrainLoginPage() {
        page.navigate("https://ztrain-web.vercel.app/auth/login");
        login = new loginPage(page);
        login.saveScreen();
    }


    @And("I enter email address {string} and password {string}")
    public void loginIntoTheApplication(String email,String pass ) {
        login.enterEmail(email); login.enterPassword(pass);
        login.saveScreen();
    }


    @And("I clicks to the login button")
    public void iClicksToTheLoginButton() {
        login.clickLoginButton();
        login.saveScreen();
    }



//    @Then("The user is connected with  {string}")
//    public void theUserIsConnectedWith(String confirmationLogin) {
//        login.saveScreen();
//        String confirmation = login.getConfirmationLogin();
//        Assert.assertEquals(confirmation,confirmationLogin);
//    }

    @Then("I'm login")
    public void iMLogin() {
        assert page.url().equals("https://ztrain-web.vercel.app/home");
        login.saveScreen();
    }

    @Then("Access is denied with the message {string}")
    public void accessIsDeniedWithTheMessage(String failedLogin) {
        String failed = login.getFailedLogin();
        Assert.assertEquals(failed,failedLogin);
        login.saveScreen();
    }

    @Then("Access is denied with {string}")
    public void accessIsDeniedWith(String fail_email) {
        String fail = login.getFail_email();
        Assert.assertEquals(fail,fail_email);
        login.saveScreen();
    }

    @When("I'm in the login page with {string} and password {string}")
    public void iMInTheLoginPageWithAndPassword(String arg0, String arg1) {
        login.enterEmail(arg0);
        login.enterPassword(arg1);
        login.clickLoginButton();
        login.saveScreen();
    }

    @And("I clicks to the logout button")
    public void iClicksToTheLogoutButton() {

        login.logoutButton();
        login.saveScreen();
    }

    @Then("I'm logout")
    public void iMLogout() {
        assert page.url().equals("https://ztrain-web.vercel.app/auth/login");
        login.saveScreen();
    }


}
