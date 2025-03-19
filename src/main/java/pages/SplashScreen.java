package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import java.time.Duration;
import io.appium.java_client.pagefactory.*;


public class SplashScreen {

  private AppiumDriver driver;

  public SplashScreen(AppiumDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"Spotify\"`]")
  private WebElement splashScreenSpotifyLogo;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"Encore.Label\")]")
  private WebElement splashScreenTextText;

  @iOSXCUITFindBy(accessibility = "Welcome-LoginButton")
  private WebElement loginButton;

  @iOSXCUITFindBy(accessibility = "Welcome-SignupButton")
  private WebElement signupButton;

  public void verifyAppLaunchAndLoginPageTextIsDisplayed(){
    splashScreenTextText.isDisplayed();
  }

  public String getLoginPageTextMessage(){
    return splashScreenTextText.getText();
  }

  public void tapOnLoginButton(){
    loginButton.click();
  }

  public void tapOnSignupButton(){
    signupButton.click();
  }
}
