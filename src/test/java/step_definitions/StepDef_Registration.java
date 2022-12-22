package step_definitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_object.loginPage;
import page_object.registrationPage;

public class StepDef_Registration {
    registrationPage registration;
    Playwright playwright = Playwright.create();
    BrowserType chrome = playwright.chromium( );
    Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();

    @Given("i'm Ztrain login page")
    public void iMZtrainLoginPage() {
        page.navigate("https://ztrain-web.vercel.app/auth/login");
        registration = new registrationPage(page);
    }
    @When("I click on register button")
    public void iClickOnRegisterButton() {
        registration.clickRegisterButton();
    }

    @And("I fill in the form with the information {string} {string} {string}")
    public void iFillInTheFormWithTheInformation(String email, String password, String confirmpass) {
        registration.enterEmailRegister(email);
        registration.enterPasswordRegister(password);
        registration.enterConfirmPassword(confirmpass);
    }

    @Then("I clicks validation button")
    public void iClicksValidationButton() {
        registration.clickValidationButton();
    }


    @Then("The user is connected {string}")
    public void theUserIsConnected(String confirmationLogin) {
        String confirmation = registration.getConfirmationLogin();
        Assert.assertEquals(confirmation,confirmationLogin);
    }

    @Then("Access is denied  {string}")
    public void accessIsDenied(String failedRegister) {
        String failed = registration.getFailedRegister();
        Assert.assertEquals(failed,failedRegister);
    }
}
