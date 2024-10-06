package Tests;

import Pages.QAPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QATest extends BaseTest{

    private QAPage qaPage;
    String jobName="Quality Assurance";
    String departmentName="Quality Assurance";
    String jobLocation="Istanbul, Turkey";


    @BeforeMethod
    public void setup(){
        qaPage=new QAPage(driver);
        qaPage.goToQAPage();
    }


    @Test(description = "Check the job detail of QA job list")
    public void checkPreferenceQAJobList(){
        qaPage.goToSeeAllQAJobs();
        qaPage.selectLocation(jobLocation);
        qaPage.selectDepartment(departmentName);
        qaPage.checkJobPresence(departmentName,jobLocation);
        qaPage.checkAllJobDetail(jobName,jobLocation,departmentName);
        qaPage.checkJobDetail(jobName);
    }

}
