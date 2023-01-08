package page_object;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class searchPage {
    Page page;
    // Locator — — — -

    String emailUser = "id=email_login";
    String password = "id=password_login";
    String clickLogin = "id=btn_login";
    String searchBar = "id=style_input_navbar_search__Scaxy";
    String failSearch = "id=style_empty_result___y6P_";
    String searchResult = "#style_popular_product_wrapper__z6J0h div div";

    Browser browser;
    BrowserContext browserContext;

    // initialize Page using constructor

    public searchPage(Page page) {
        this.page = page;
    }

    public void enterEmailandPassword(String email, String pwd) {
        page.fill(emailUser, email);
        page.fill(password, pwd);
        page.click(clickLogin);}

    public void Idoasearch(String searchTerm) {
        page.waitForTimeout(10000);
        page.fill(searchBar, searchTerm);}
    public String getResultSearch() {
        return page.textContent(failSearch);}
    public Boolean ResultSearch() {
        return page.isVisible(searchResult);}
    public void saveScreen() {
        Allure.addAttachment("screenshot",
                new ByteArrayInputStream((page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png"))))));
    }




}


