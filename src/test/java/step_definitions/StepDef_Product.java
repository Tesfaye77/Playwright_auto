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
import page_object.productPage;
import page_object.searchPage;

public class StepDef_Product {
    productPage product;
    Playwright playwright = Playwright.create();
    BrowserType chrome = playwright.chromium( );
    Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    @Given("I am connected to my account {string} and {string}")
    public void iAmConnectedToMyAccountAnd(String arg0, String arg1) {
        page.navigate("https://ztrain-web.vercel.app/auth/login");
        product = new productPage(page);
        product.enterEmailandPassword(arg0,arg1);
    }

    @And("I added to my bag")
    public void iAddedToMyBag() {
        product.addProduct();
    }


    @Then("I can see the message {string}")
    public void iCanSeeTheMessage(String verify_except) {
        String verify_obtains = product.verifyaddproduct();
        Assert.assertEquals(verify_except,verify_obtains);
    }
}
