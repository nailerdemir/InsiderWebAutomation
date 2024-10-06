package Tests;

import Pages.CareersPage;
import Pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CareersTest extends BaseTest{

    private CareersPage careersPage;
    private HomePage    homePage;

    @BeforeMethod
    public void setup() {
        careersPage = new CareersPage(driver);
        homePage=new HomePage(driver);
    }

    @Test(description = "Check Careers Page")
    public void checkCareersPage(){
        homePage.goToCareersPage();
        careersPage.checkCareerPageBlocks();
    }








}
