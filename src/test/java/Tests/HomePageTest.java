package Tests;

import Pages.HomePage;
import Utility.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private HomePage homePage;
    String homePageUrl = "https://useinsider.com/";
    String homePageTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
    String careersPageUrl = "#1 Leader in Individualized, Cross-Channel CX — Insider";

    @BeforeMethod
    public void setup() {
        homePage = new HomePage(driver);
    }

    @Test(description = "Go to homepage and check blocks")
    public void homePageCheck() {
        homePage.goToHomePage(homePageUrl);
        homePage.checkHomePage(homePageTitle);
    }

    @Test(description = "Check Career Page")
    public void careerPageCheck(){
        homePage.goToHomePage(homePageUrl);
        homePage.clickNavBarMenus("Company");
        homePage.clickButton("Careers");
    }
}

