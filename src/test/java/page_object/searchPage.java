package page_object;

import com.microsoft.playwright.Page;

public class searchPage {
    Page page;
    // Locator — — — -

    String emailUser = "id=email_login";
    String password = "id=password_login";
    String clickLogin = "id=btn_login";
    String searchBar = "id=style_input_navbar_search__Scaxy";
    String failSearch = "id=style_empty_result___y6P_";



    // initialize Page using constructor

    public searchPage(Page page) {
        this.page = page;
    }

    public void enterEmailandPassword(String email, String pwd) {
        page.fill(emailUser, email);
        page.fill(password, pwd);
        page.click(clickLogin);}

    public void Idoasearch(String searchTerm) {
        page.fill(searchBar, searchTerm);}
    public String getResultSearch() {
        return page.textContent(failSearch);}

}
