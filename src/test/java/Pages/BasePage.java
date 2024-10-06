package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class BasePage {

    protected WebDriver driver;
    protected SoftAssert soft;
    protected WebDriverWait wait;


    public BasePage (WebDriver driver){
        this.driver=driver;
        soft=new SoftAssert();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }




    public void scrollTo(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
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

    public List<WebElement> getListElements(WebElement mainElement){
        wait.until(visibilityOf(mainElement));
        return mainElement.findElements(By.cssSelector(" ul li"));
    }

    public List<WebElement> getDropDownListButtons(WebElement mainElement){
        wait.until(visibilityOf(mainElement));
        return mainElement.findElements(By.cssSelector(" div a"));
    }


}
