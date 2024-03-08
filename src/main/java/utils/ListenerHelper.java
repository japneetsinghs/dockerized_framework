//package utils;
//
//import base.BasePage;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.Markup;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import lombok.SneakyThrows;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//import static utils.ExtentReportHelper.getReportObject;
//
//public class ListenerHelper implements ITestListener
//{
//    private final ExtentReports extentReports = getReportObject();
//    ExtentTest logger;
//    //ThreadLocal to generate the report for parallel execution
//    ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();
//
//    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//    public WebDriver driver = null;
//
//
//    public void onTestStart(ITestResult result)
//    {
//        logger = extentReports.createTest(result.getMethod().getMethodName(),
//                "<b> Description for test:</b> "+result.getMethod().getDescription());
//        extentTestThreadLocal.set(logger);
//        logger.assignCategory(result.getMethod().getGroups());
//        extentTestThreadLocal.get().log(Status.INFO, "Driver Start Time: "+ dtf.format(LocalDateTime.now()));
//        try {
//            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void onTestSuccess(ITestResult result)
//    {
//        extentTestThreadLocal.get().log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName()+"is successful!!", ExtentColor.GREEN));
//    }
//
//    public void onTestFailure(ITestResult result)
//    {
//        extentTestThreadLocal.get().log(Status.FAIL, MarkupHelper.createLabel((result.getMethod().getMethodName()+"is failed!!"), ExtentColor.RED));
//        extentTestThreadLocal.get().log(Status.FAIL, result.getThrowable());
//        String screenshotPath;
//
//        try {
//            screenshotPath = BasePage.getScreenshot(result.getMethod().getMethodName()+".jpg", driver);
//            extentTestThreadLocal.get().fail((Markup) MediaEntityBuilder.createScreenCaptureFromBase64String(BasePage.convertImg_Base64(screenshotPath)));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//
//    public void onTestSkipped(ITestResult result) {
//        // not implemented
//
//
//    }
//
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        // not implemented
//    }
//
//    public void onTestFailedWithTimeout(ITestResult result) {
//
//    }
//
//    public void onStart(ITestContext context) {
//        // not implemented
//    }
//
//    public void onFinish(ITestContext context)
//    {
//        extentTestThreadLocal.get().log(Status.INFO, "Driver quit time:  "+ dtf.format(LocalDateTime.now()));
//        extentReports.flush();
//    }
//}