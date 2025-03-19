package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.ConfigReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseEngine {
  protected static IOSDriver driver;
  protected static ExtentReports extent;
  protected static ExtentTest test;

  @BeforeTest
  public void setup() throws MalformedURLException {

    XCUITestOptions options = new XCUITestOptions();
    options.setDeviceName(ConfigReader.getConfigValue("deviceName"));
    options.setPlatformName(ConfigReader.getConfigValue("platformName"));
    options.setPlatformVersion(ConfigReader.getConfigValue("platformVersion"));
    options.setApp(ConfigReader.getConfigValue("app"));
    options.setUdid(ConfigReader.getConfigValue("udid"));
    options.setAutomationName(ConfigReader.getConfigValue("automationName"));

    driver = new IOSDriver(new URL("http://localhost:4723/"), options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterTest
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @BeforeSuite
  public void setUpReporting() {
    ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
    extent = new ExtentReports();
    extent.attachReporter(spark);
    extent.setSystemInfo("OS", "iOS");
    extent.setSystemInfo("Tester", "Dhiraj Gawali");
  }

  public static ExtentTest createTest(String testName) {
    test = extent.createTest(testName);
    return test;
  }

  @AfterSuite
  public void tearDownReporting() {
    extent.flush();
  }
}
