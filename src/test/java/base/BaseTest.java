package base;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {

    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void setUpReport() {
        extent = ExtentReportManager.getReporter();
    }

    @BeforeClass
    public void setupRestAssured() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    @AfterMethod
    public void flushTestReport() {
        extent.flush();
    }

    protected void createTest(String testName) {
        test.set(extent.createTest(testName));
    }

    protected ExtentTest getTest() {
        return test.get();
    }
}