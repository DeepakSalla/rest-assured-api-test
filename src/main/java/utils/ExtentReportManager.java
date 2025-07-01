package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    static {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/extent-report.html");
        reporter.config().setReportName("API Test Report");
        reporter.config().setDocumentTitle("API Automation Results");
        extentReports.attachReporter(reporter);
    }

    public static ExtentReports getReporter() {
        return extentReports;
    }
}