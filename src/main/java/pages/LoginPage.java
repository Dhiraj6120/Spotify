package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import java.time.Duration;
import io.appium.java_client.pagefactory.*;


public class LoginPage {

  private AppiumDriver driver;

  public LoginPage(AppiumDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"Spotify\"`]")
  private WebElement loginPageLogoImage;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"Encore.Label\")]")
  private WebElement loginPageText;

  public void verifyAppLaunchAndLoginPageTextIsDisplayed(){
    loginPageText.isDisplayed();
  }

  public String getLoginPageTextMessage(){
    return loginPageText.getText();
  }
}
