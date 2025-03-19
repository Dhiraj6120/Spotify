package utils;

import base.BaseEngine;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GenericMethods extends BaseEngine {
  public static void staticWait(int timeToWaitInSecond){
    try {
      Thread.sleep(timeToWaitInSecond * 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static void IsElementDisplayed(WebElement element) {
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
}