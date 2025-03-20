package pages;

import base.BaseEngine;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CustomMethods;

public class LoginPage extends BaseEngine {
  private AppiumDriver driver;

  public LoginPage(AppiumDriver driver){
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @iOSXCUITFindBy(accessibility = "IntentLed-PhoneNumberButton")
  private WebElement continueWithPhoneNumberButton;

  @iOSXCUITFindBy(accessibility = "IntentLed-ContinueWithEmailButton")
  private WebElement continueWithEmailButton;

  @iOSXCUITFindBy(accessibility = "IntentLed-GoogleButton")
  private WebElement continueWithGoogleButton;

  @iOSXCUITFindBy(iOSNsPredicate = "name == \"Encore.Label\" AND label == \"Log in to Spotify\"")
  private WebElement loginPageHeading;

  @iOSXCUITFindBy(accessibility = "phone-number-entry-text-field")
  private WebElement phoneNumberEntryTextbox;

  @iOSXCUITFindBy(accessibility = "phone-number-entry-title-label-internal")
  private WebElement phoneNumberEntryTextboxHeading;

  @iOSXCUITFindBy(iOSNsPredicate = "name == \"Next\"")
  private WebElement phoneNumberNextButton;

  @iOSXCUITFindBy(accessibility = "PopUp.Dialog.Title-internal")
  private WebElement errorPopupHeadingText;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Encore.Label-internal\" and @label=\"Don’t have an account?\"]")
  private WebElement doNotHavAccount;

  @iOSXCUITFindBy(iOSNsPredicate = "name == \"Encore.Label-internal\" AND label == \"Email or username\"")
  private WebElement logInWithEmailScreenEmailTextBoxHeading;

  @iOSXCUITFindBy(accessibility = "Back")
  private WebElement logInWithEmailBack;

  public String getLoginPageHeadingText(){
    return loginPageHeading.getText();
  }

  public void verifyContinueWithEmailButton(){
    CustomMethods.verifyElementDisplayed(continueWithEmailButton);
  }

  public void tapContinueWithEmailButton(){
    continueWithEmailButton.click();
  }

  public void verifyContinueWithPhoneNumberButton(){
    CustomMethods.verifyElementDisplayed(continueWithPhoneNumberButton);
  }

  public void verifyContinueWithGoogleButton(){
    CustomMethods.verifyElementDisplayed(continueWithGoogleButton);
  }

  public void verifyLoginOptions(){
    verifyContinueWithGoogleButton();
    verifyContinueWithEmailButton();
    verifyContinueWithPhoneNumberButton();
  }

  public String getDoNotHavAccountText(){
    return doNotHavAccount.getText();
  }

  public void tapOnContinueWithPhoneNumberButton(){
    continueWithPhoneNumberButton.click();
  }

  public void enterPhoneNumber(String phoneNumber){
    phoneNumberEntryTextbox.sendKeys(phoneNumber);
  }

  public void tapOnPhoneNumberNextButton(){
    phoneNumberNextButton.click();
  }

  public String getErrorPopupHeadingText(){
    return errorPopupHeadingText.getText();
  }

  public void verifyLogInWithEmailScreenEmailTextBoxHeading(){
    CustomMethods.verifyElementDisplayed(logInWithEmailScreenEmailTextBoxHeading);
  }

  public void tapOnLogInWithEmailBack(){
    logInWithEmailBack.click();
  }

  public void verifyUserNavigatingBackToLoginOptionsPage(){
    verifyLoginOptions();
  }

  public void verifyPhoneNumberEntryTextboxHeading(){
    CustomMethods.verifyElementDisplayed(phoneNumberEntryTextboxHeading);
  }
}
