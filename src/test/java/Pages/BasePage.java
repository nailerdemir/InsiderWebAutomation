package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class BasePage {

    protected WebDriver driver;
    protected SoftAssert soft;
    protected WebDriverWait wait;
    protected FluentWait<WebDriver> fluentWait=new FluentWait<>(driver);


    public BasePage (WebDriver driver){
        this.driver=driver;
        soft=new SoftAssert();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        fluentWait.withTimeout(Duration.ofSeconds(20));
        fluentWait.pollingEvery(Duration.ofSeconds(2));
        fluentWait.ignoring(NoSuchElementException.class);
    }


    public void moveToElement(WebElement element){
        Actions action=new Actions(driver);
        action.moveToElement(element).perform();
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


    public void waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return jQuery.active == 0").equals(true)
        );
    }


    public void switchWindow(){
        sleep(2000);
        for (String handle:driver.getWindowHandles()){
            driver.switchTo().window(handle);
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
