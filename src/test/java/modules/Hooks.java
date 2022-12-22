package modules;
// todo: configure actions to be run before and after scenario
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class Hooks {
    Page page;
    @Before
    public void setUp(){


    }


    @After
    public void TearsDown(){


    }


}
