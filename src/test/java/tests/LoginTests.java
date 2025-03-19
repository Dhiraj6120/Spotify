package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.GenericMethods;

public class LoginTests extends BaseTest {

  @Test
  public void veriyfyUserIsAbleToLaunchApplication(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.verifyAppLaunchAndLoginPageTextIsDisplayed();
  }
}
