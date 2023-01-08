package page_object;

import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class loginPage {
     Page page;
    // Locator — — — -

    String emailUser = "id=email_login";
    String password = "id=password_login";
    String clickLogin = "id=btn_login";
    String handleconfirmation = "id=style_content_logo__pkvMP";
    String confirmationLogin = "id=style_content_logo__pkvMP";
    String failedLogin = "text=Email ou mot de passe incorrect";
    String fail_email = "text=Le format de l'email est invalid";
    String handle_mouse = "id=style_avatar_wrapper__pEGIQ";
    String logout_bouton = "text=Se déconnecter";




    // initialize Page using constructor

    public loginPage(Page page) {
        this.page = page;
    }



    //Create methods

    public void enterEmail(String email) {
        page.fill(emailUser, email);}

    public void enterPassword(String pass) {
        page.fill(password, pass);}

    public void clickLoginButton() {
        page.click(clickLogin);
        page.waitForTimeout(3000);
        }
    public String getConfirmationLogin() {

        return page.textContent(confirmationLogin);

    }
    public String getFailedLogin() {
        return page.textContent(failedLogin);}
    public String getFail_email() {

        return page.textContent(fail_email);}
    public void logoutButton() {
        page.click(handle_mouse);
        page.click(logout_bouton);}

    public void saveScreen() {
         Allure.addAttachment("screenshot",
                 new ByteArrayInputStream((page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png"))))));
    }



}
