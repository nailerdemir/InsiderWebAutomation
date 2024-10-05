package Tests;

import Utility.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver=Driver.getDriver();
        if (driver == null) {
            throw new IllegalStateException("Driver boş.");
        }
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        Driver.closeDriver();
    }
}
