package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import java.time.Duration;
import io.appium.java_client.pagefactory.*;
import utils.CustomMethods;


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

  @iOSXCUITFindBy(iOSNsPredicate = "name == \"Welcome-SignupButton\"")
  private WebElement signupButton;

  public void verifyAppLaunchAndLoginPageTextIsDisplayed(){
    splashScreenTextText.isDisplayed();
  }

  public void verifySplashScreenLogo(){
    CustomMethods.verifyElementDisplayed(splashScreenSpotifyLogo);
  }

  public String getLoginPageTextMessage(){
    return splashScreenTextText.getText();
  }

  public void tapOnLoginButton(){
    loginButton.click();
  }

  public void verifySignUpButtonDisplayed(){
    CustomMethods.verifyElementDisplayed(signupButton);
  }

  public void verifyLoginButtonDisplayed(){
    CustomMethods.verifyElementDisplayed(loginButton);
  }

  public void tapOnSignupButton(){
    signupButton.click();
  }
}
