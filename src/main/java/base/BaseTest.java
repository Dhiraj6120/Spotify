package base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ConfigReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
  protected static IOSDriver driver;

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
}
