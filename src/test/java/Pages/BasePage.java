package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected SoftAssert soft;
    protected WebDriverWait wait;




    public BasePage (WebDriver driver){
        this.driver=driver;
        soft=new SoftAssert();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }



    public void goToUrl(String url){
        driver.get(url);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
