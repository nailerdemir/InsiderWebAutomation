package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class QAPage extends BasePage{

    public QAPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="wt-cli-accept-btn")
    WebElement cookieAccept_Button;

    @FindBy(id="page-head")
    WebElement pageHead;

    @FindBy(css = ".btn.btn-outline-secondary.rounded.text-medium.mt-2.py-3.px-lg-5.w-100.w-md-50")
    WebElement seeAllQAJob_Button;

    @FindBy(id = "select2-filter-by-location-container")
    WebElement allLocationDropDownList_Button;

    @FindBy(css = ".select2-results")
    WebElement allLocations;

    @FindBy(id = "select2-filter-by-department-container")
    WebElement allDepartmentsDropDownList_Button;

    @FindBy(css = ".select2-results")
    WebElement allDepartments;

    @FindBy(css = ".position-list-item-wrapper.bg-light")
    List<WebElement> openPositionList;

    @FindBy(css = ".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5")
    WebElement viewRole_Button;



    String qaPageUrl="https://useinsider.com/careers/quality-assurance/";


    public void goToQAPage(){
        goToUrl(qaPageUrl);
        wait.until(visibilityOf(pageHead));
        wait.until(elementToBeClickable(cookieAccept_Button)).click();
    }

    public void goToSeeAllQAJobs(){
        wait.until(elementToBeClickable(seeAllQAJob_Button)).click();
    }

    public void selectLocation(String location){
        waitForPageToLoad();
        scrollTo(allLocationDropDownList_Button);
        allLocationDropDownList_Button.click();
        wait.until(visibilityOf(allLocations));
        List<WebElement> locationElements=getListElements(allLocations);
        for (WebElement locationElement:locationElements){
            if (locationElement.getText().equals(location)){locationElement.click();break;}
        }
    }

    public void selectDepartment(String department) {
        wait.until(elementToBeClickable(allDepartmentsDropDownList_Button)).click();
        wait.until(visibilityOf(allDepartments));
        List<WebElement> departmentElements = getListElements(allDepartments);
        for (WebElement departmentElement : departmentElements) {
            if (departmentElement.getText().equals(department)) {
                departmentElement.click();
                break;
            }
        }
        sleep(2000);
    }

    public void checkJobPresence(String jobName,String location){
        wait.until(visibilityOf(openPositionList.get(0)));
        soft.assertEquals(openPositionList.get(0).findElement(By.cssSelector(" span")).getText(),jobName);
        soft.assertEquals(openPositionList.get(0).findElement(By.cssSelector(" div")).getText(),location);
        soft.assertAll();
    }

    public void checkAllJobDetail(String jobName, String location, String department){
        wait.until(visibilityOf(openPositionList.get(0)));
        scrollTo(openPositionList.get(0));
        for (WebElement job:openPositionList){
            soft.assertTrue(job.findElement(By.cssSelector(" p")).getText().contains(jobName));
            soft.assertTrue(job.findElement(By.cssSelector(" span")).getText().contains(department));
            soft.assertTrue(job.findElement(By.cssSelector(" div")).getText().contains(location));
        }
        soft.assertAll();
    }

    public void checkJobDetail(String jobName){
        wait.until(visibilityOf(openPositionList.get(0)));
        moveToElement(openPositionList.get(0));
        wait.until(elementToBeClickable(viewRole_Button)).click();
        switchWindow();
        soft.assertTrue(getCurrentUrl().contains("jobs.lever"));
        soft.assertTrue(getPageTitle().contains(jobName));
        soft.assertAll();
    }
}
