package pages;

import base.BaseEngine;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CustomMethods;

public class EmailLoginPage extends BaseEngine {

  private AppiumDriver driver;

  public EmailLoginPage(AppiumDriver driver){
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(10)), this);
  }

  @iOSXCUITFindBy(iOSNsPredicate = "name == \"Encore.Label-internal\" AND label == \"Email or username\"")
  private WebElement logInWithEmailScreenEmailTextBoxHeading;

  @iOSXCUITFindBy(accessibility = "Login-UsernameInput")
  private WebElement logInWithEmailScreenEmailInputTextField;

  @iOSXCUITFindBy(accessibility = "Login-PasswordInput")
  private WebElement logInWithEmailScreenPasswordInputTextField;

  @iOSXCUITFindBy(iOSNsPredicate = "name == \"Encore.Label-internal\" AND label == \"Password\"")
  private WebElement logInWithEmailScreenPasswordTextBoxHeading;

  @iOSXCUITFindBy(accessibility = "Secure password.")
  private WebElement logInWithEmailScreenPasswordEyeButton;

  @iOSXCUITFindBy(accessibility = "Login-LoginButton")
  private WebElement logInWithEmailScreenLoginButton;

  @iOSXCUITFindBy(iOSNsPredicate = "name == \"This email and password combination is incorrect.\"")
  private WebElement invalidEmailPasswordErrorMessage;

  public void verifyLogInWithEmailScreenEmailTextBoxHeading(){
    CustomMethods.verifyElementDisplayed(logInWithEmailScreenEmailTextBoxHeading);
  }

  public void verifyLogInWithEmailScreenPasswordTextBoxHeading(){
    CustomMethods.verifyElementDisplayed(logInWithEmailScreenPasswordTextBoxHeading);
  }

  public void enterEmailID(String emailId){
    CustomMethods.enterText(logInWithEmailScreenEmailInputTextField, emailId);
  }

  public void enterPasswordField(String password){
    CustomMethods.enterText(logInWithEmailScreenPasswordInputTextField, password);
  }

  public void tapOnLogInWithEmailScreenLoginButton(){
    CustomMethods.clickElement(logInWithEmailScreenLoginButton);
  }

  public void verifyErrorMessageForInvalidUser(){
    System.out.println(invalidEmailPasswordErrorMessage.getText());
    CustomMethods.verifyElementDisplayed(invalidEmailPasswordErrorMessage);
  }

}
