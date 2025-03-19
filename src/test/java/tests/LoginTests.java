package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

  @Test
  public void veriyfyUserIsAbleToLaunchApplication(){
    test = createTest("Valid Login Test");
    test.info("Launching Spotify app");
    LoginPage loginPage = new LoginPage(driver);
    loginPage.verifyAppLaunchAndLoginPageTextIsDisplayed();
    test.pass("Test Case is Passed");
  }
}
