package Tests;

import Pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    private HomePage homePage;

    String homePageUrl = "https://useinsider.com/";
    String homePageTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
    String careersPageUrl = "https://useinsider.com/careers/";


    @BeforeMethod
    public void setup() {
        homePage = new HomePage(driver);
        homePage.goToHomePage();
    }

    @Test(description = "Go to homepage and check blocks")
    public void homePageCheck() {
        homePage.checkCurrentUrl(homePageUrl);
        homePage.checkHomePage(homePageTitle);
    }

    @Test(description = "Check Career Page")
    public void careerPageCheck(){
        homePage.clickNavBarMenus("Company");
        homePage.clickButton("Careers");
        homePage.checkCurrentUrl(careersPageUrl);
    }
}

