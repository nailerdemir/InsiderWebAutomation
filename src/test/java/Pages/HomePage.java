package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;



public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);}


    @FindBy(id="navigation")
    WebElement navigationBar;

    @FindBy(id="navbarNavDropdown")
    WebElement navigationBarDropDown;

    @FindBy(css=".dropdown-menu.new-menu-dropdown-layout-6.show")
    WebElement companyMenuDropDownElements;

    //@FindBy(css=".new-menu-dropdown-layout-6-mid-container a:nth-child(2)")
    WebElement careersButton;


    public void goToHomePage(String homePageUrl){
        goToUrl(homePageUrl);
        wait.until(visibilityOf(navigationBar));
    }

    public void checkHomePage(String homePageTitle){
        soft.assertEquals(getPageTitle(),homePageTitle);
        soft.assertAll();
    }

    public void clickNavBarMenus(String menuName){
        wait.until(visibilityOf(navigationBar));
        List<WebElement> elementList= getListElements(navigationBarDropDown);
        for (WebElement element:elementList){
            if (element.findElement(By.cssSelector(" a")).getText().equals(menuName)){element.click();break;}
        }
        wait.until(visibilityOf(companyMenuDropDownElements));
    }

    public void clickButton(String buttonName){
        List<WebElement> elements=getDropDownListButtons(companyMenuDropDownElements);
        for (WebElement element:elements){
            if (element.getText().equals(buttonName)){element.click();break;}
            }
    }

    public void checkCurrentUrl(String url){
        Assert.assertEquals(getCurrentUrl(),url);
    }
}

