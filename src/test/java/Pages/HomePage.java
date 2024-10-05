package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);}


    @FindBy(id="navigation")
    WebElement navigationBar;



    public void goToHomePage(String homePageUrl){
        goToUrl(homePageUrl);
        wait.until(ExpectedConditions.visibilityOf(navigationBar));
    }

    public void checkHomePage(String homePageTitle){
        soft.assertEquals(getPageTitle(),homePageTitle);
        soft.assertAll();
    }
















}
