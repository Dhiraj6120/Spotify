package pages;

import base.BaseEngine;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseEngine {
  private AppiumDriver driver;

  public LoginPage(AppiumDriver driver){
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @iOSXCUITFindBy(accessibility = "IntentLed-PhoneNumberButton")
  private WebElement continueWithPhoneNumberButton;

  @iOSXCUITFindBy(accessibility = "phone-number-entry-text-field")
  private WebElement phoneNumberEntryTextbox;

  @iOSXCUITFindBy(iOSNsPredicate = "name == \"Next\"")
  private WebElement phoneNumberNextButton;

  @iOSXCUITFindBy(accessibility = "PopUp.Dialog.Title-internal")
  private WebElement errorPopupHeadingText;

  public void tapOnContinueWithPhoneNumberButton(){
    continueWithPhoneNumberButton.click();
  }

  public void enterPhoneNumber(String phoneNumber){
    phoneNumberEntryTextbox.sendKeys(phoneNumber);
  }

  public void tapOnPhoneNumberNextButton(){
    phoneNumberNextButton.click();
  }

  public String verifyErrorPopupHeadingText(){
    return errorPopupHeadingText.getText();
  }
}
