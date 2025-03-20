package utils;

import base.BaseEngine;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CustomMethods extends BaseEngine {
  public static void staticWait(int timeToWaitInSecond){
    try {
      Thread.sleep(timeToWaitInSecond * 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static void verifyElementDisplayed(WebElement element) {
    try {
      if (element.isDisplayed()) {
        test.pass("Element '" + element + "' is displayed on the page.");
      } else {
        test.fail("Element '" + element + "' is not displayed on the page.");
        throw new RuntimeException("Element '" + element + "' is not displayed on the page.");
      }
    } catch (NoSuchElementException e) {
      test.fail("Element '" + element + "' is not displayed on the page.");
      throw new RuntimeException("Element '" + element + "' is not displayed on the page.", e);
    }
  }

  public static void enterText(WebElement element, String textToEnter){
    try {
      if(element.isDisplayed()){
        element.sendKeys(textToEnter);
        test.info("Entered text"+textToEnter+" in "+element);
      }
    }catch (NoSuchElementException e){
      test.fail("Element '" + element + "' is not displayed on the page.");
      throw new RuntimeException("Element '" + element + "' is not displayed on the page.", e);
    }
  }

  public static void clickElement(WebElement element){
    try {
      if(element.isDisplayed()){
        element.click();
        test.info("Clicked on "+element);
      }
    }catch (NoSuchElementException e){
      test.fail("Not able to interact with " + element);
      throw new RuntimeException(e);
    }
  }
}