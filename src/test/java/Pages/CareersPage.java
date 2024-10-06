package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CareersPage extends BasePage{

    public CareersPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "page-head")
    WebElement pageHead;

    @FindBy(id="career-our-location")
    WebElement locationBlock;

    @FindBy(id="career-find-our-calling")
    WebElement teamsBlock;

    @FindBy(css=".elementor-section.elementor-top-section.elementor-element.elementor-element-a8e7b90.elementor-section-full_width.elementor-section-height-default.elementor-section-height-default")
    WebElement lifeAtInsiderBlock;




    public boolean checkLocationsBlock(){
        scrollTo(locationBlock);
        return wait.until(visibilityOf(locationBlock)).isDisplayed();
    }

    public boolean checkTeamsBlock(){
        scrollTo(teamsBlock);
        return wait.until(visibilityOf(teamsBlock)).isDisplayed();
    }

    public boolean checkLifeAtInsiderBlock(){
        scrollTo(lifeAtInsiderBlock);
        return wait.until(visibilityOf(lifeAtInsiderBlock)).isDisplayed();
    }

    public void checkCareerPageBlocks(){
        wait.until(visibilityOf(pageHead));
        soft.assertTrue(checkLocationsBlock());
        soft.assertTrue(checkTeamsBlock());
        soft.assertTrue(checkLifeAtInsiderBlock());
        soft.assertAll();
    }
}
