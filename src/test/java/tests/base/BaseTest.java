package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SearchHomePage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    protected SearchHomePage searchHomePage;

    @BeforeMethod
    public void setUp(){
        Configuration.browser = "chrome";
        WebDriverRunner.getAndCheckWebDriver().manage().window().maximize();
        Configuration.timeout = 60000;

        searchHomePage = new SearchHomePage();
    }

    @AfterMethod(alwaysRun = true)
        public void tearDown(){
        if (getWebDriver() != null){
            getWebDriver().quit();
        }
    }
}
