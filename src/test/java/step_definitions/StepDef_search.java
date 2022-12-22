package step_definitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_object.loginPage;
import page_object.searchPage;

public class StepDef_search {

    searchPage search;
    Playwright playwright = Playwright.create();
    BrowserType chrome = playwright.chromium( );
    Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();

    @Given("I am connected to my account with {string} and {string}")
    public void iAmConnectedToMyAccountWithAnd(String email, String password) {
        page.navigate("https://ztrain-web.vercel.app/auth/login");
        search = new searchPage(page);
        search.enterEmailandPassword(email,password);
    }

    @When("I do a multiple keyword search for {string}")
    public void iDoAMultipleKeywordSearchFor(String terms) {
        search.Idoasearch(terms);
    }

    @Then("I see a multiple keyword search result page")
    public void iSeeAMultipleKeywordSearchResultPage() {
    }


    @Then("I see a message {string}")
    public void iSeeAMessage(String result_exc) {
        String true_result = search.getResultSearch();
        Assert.assertEquals(true_result,result_exc);
    }

}
