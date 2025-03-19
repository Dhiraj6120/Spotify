package tests;

import base.BaseEngine;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SplashScreen;

public class AppTests extends BaseEngine {

  @Test
  public void verifyUserIsAbleToLaunchApplication(){
    test = createTest("Valid user is able to Launch Application Test");
    test.info("Launching Spotify app");
    SplashScreen splashScreen = new SplashScreen(driver);
    splashScreen.verifyAppLaunchAndLoginPageTextIsDisplayed();
    test.pass("App Launched");
  }

  @Test
  public void verifyErrorPopupForMobileNumberLessThanTenDigits(){
    test = createTest("Valid user is able to Login to Spotify Application");
    test.info("Launching Spotify app");
    SplashScreen splashScreen = new SplashScreen(driver);
    splashScreen.tapOnLoginButton();
    LoginPage loginPage = new LoginPage(driver);
    loginPage.tapOnContinueWithPhoneNumberButton();
    loginPage.enterPhoneNumber("12345");
    loginPage.tapOnPhoneNumberNextButton();
    Assert.assertEquals(loginPage.verifyErrorPopupHeadingText(), "Check your phone number");
  }
}
