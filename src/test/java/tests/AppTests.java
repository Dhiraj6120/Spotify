package tests;

import base.BaseEngine;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailLoginPage;
import pages.LoginPage;
import pages.SplashScreen;
import utils.CustomMethods;

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
  public void validateLoginScreenElements(){
    test = createTest("Valid user is able to Login to Spotify Application");
    test.info("Launching Spotify app");
    SplashScreen splashScreen = new SplashScreen(driver);
    splashScreen.verifyAppLaunchAndLoginPageTextIsDisplayed();
    splashScreen.verifySplashScreenLogo();
    splashScreen.verifyLoginButtonDisplayed();
    splashScreen.verifySignUpButtonDisplayed();
    splashScreen.tapOnLoginButton();
    LoginPage loginPage = new LoginPage(driver);
    Assert.assertEquals(loginPage.getLoginPageHeadingText(), "Log in to Spotify");
    loginPage.verifyLoginOptions();
    Assert.assertEquals(loginPage.getDoNotHavAccountText(), "Don’t have an account?");
    loginPage.tapContinueWithEmailButton();
    loginPage.verifyLogInWithEmailScreenEmailTextBoxHeading();
    loginPage.tapOnLogInWithEmailBack();
    loginPage.verifyUserNavigatingBackToLoginOptionsPage();
    loginPage.tapOnContinueWithPhoneNumberButton();
    loginPage.verifyPhoneNumberEntryTextboxHeading();
    loginPage.tapOnLogInWithEmailBack();
    loginPage.verifyUserNavigatingBackToLoginOptionsPage();
  }

  @Test
  public void verifyUserIsNotAbleToLoginWithInvalidEmailCredentials(){
    test = createTest("Valid user is able to Login with email to Spotify Application");
    test.info("Launching Spotify app");
    SplashScreen splashScreen = new SplashScreen(driver);
    splashScreen.verifyAppLaunchAndLoginPageTextIsDisplayed();
    splashScreen.tapOnLoginButton();
    LoginPage loginPage = new LoginPage(driver);
    loginPage.tapContinueWithEmailButton();
    EmailLoginPage emailLoginPage = new EmailLoginPage(driver);
    emailLoginPage.verifyLogInWithEmailScreenPasswordTextBoxHeading();
    emailLoginPage.verifyLogInWithEmailScreenPasswordTextBoxHeading();
    emailLoginPage.enterEmailID("user3@example.com");
    emailLoginPage.enterPasswordField("password789");
    emailLoginPage.tapOnLogInWithEmailScreenLoginButton();
    emailLoginPage.verifyErrorMessageForInvalidUser();
    CustomMethods.staticWait(15);
  }

  @Test(dataProvider = "loginData", dataProviderClass = testdata.LoginData.class)
  public void verifyEmailLoginScenarioWithDataDrivenTesting(String email, String password){
    test = createTest("Valid user is able to Login with email to Spotify Application");
    test.info("Launching Spotify app");
    SplashScreen splashScreen = new SplashScreen(driver);
    splashScreen.verifyAppLaunchAndLoginPageTextIsDisplayed();
    splashScreen.tapOnLoginButton();
    LoginPage loginPage = new LoginPage(driver);
    loginPage.tapContinueWithEmailButton();
    EmailLoginPage emailLoginPage = new EmailLoginPage(driver);
    emailLoginPage.verifyLogInWithEmailScreenPasswordTextBoxHeading();
    emailLoginPage.verifyLogInWithEmailScreenPasswordTextBoxHeading();
    emailLoginPage.enterEmailID(email);
    emailLoginPage.enterPasswordField(password);
    emailLoginPage.tapOnLogInWithEmailScreenLoginButton();
    CustomMethods.staticWait(5);
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
    Assert.assertEquals(loginPage.getErrorPopupHeadingText(), "Check your phone number");
  }
}
