package utils;

import base.BaseEngine;
import io.appium.java_client.AppiumBy;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;


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
        captureScreenshot();
      } else {
        test.fail("Element '" + element + "' is not displayed on the page.");
        captureScreenshot();
        throw new RuntimeException("Element '" + element + "' is not displayed on the page.");
      }
    } catch (NoSuchElementException e) {
      captureScreenshot();
      test.fail("Element '" + element + "' is not displayed on the page.");
      throw new RuntimeException("Element '" + element + "' is not displayed on the page.", e);
    }
  }

  public static void enterText(WebElement element, String textToEnter){
    try {
      if(element.isDisplayed()){
        element.sendKeys(textToEnter);
        test.pass("Entered text"+textToEnter+" in "+element);
        captureScreenshot();
      }
    }catch (NoSuchElementException e){
      captureScreenshot();
      test.fail("Element '" + element + "' is not displayed on the page.");
      throw new RuntimeException("Element '" + element + "' is not displayed on the page.", e);
    }
  }

  public static void clickElement(WebElement element){
    try {
      if(element.isDisplayed()){
        element.click();
        test.pass("Clicked on "+element);
      }
    }catch (NoSuchElementException e){
      captureScreenshot();
      test.fail("Not able to interact with " + element);
      throw new RuntimeException(e);
    }
  }

  public static void captureScreenshot() {
    if (driver == null) {
      System.out.println("Driver is not initialized. Cannot capture screenshot.");
      return;
    }
    String SCREENSHOT_DIR = "/Users/dhiraj/Documents/ITConvergenceAssignment/src/test/java/Screenshots/";
    try {
      File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
      File destFile = new File(SCREENSHOT_DIR + "/" + timestamp + ".png");

      FileUtils.copyFile(srcFile, destFile);
      System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
    } catch (IOException e) {
      System.err.println("Failed to capture screenshot: " + e.getMessage());
    }
  }

  public static void swipe() {
    int xStart = 500;
    int xEnd = 500;
    int yStart = 1800;
    int yEnd = 100;

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence swipe = new Sequence(finger, 1);

    swipe.addAction(
            finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), xStart, yStart))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(
            finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), xEnd, yEnd))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(List.of(swipe));
  }

  public static void swipeAndValidate(String productName) {
    boolean isVisible = false;
    int swipeCounter = 5;
    for (int i = 0; i < swipeCounter; i++) {
      try {
        WebElement ele = driver.findElement(
            AppiumBy.xpath("//android.widget.TextView[@text=\"" + productName + "\"]"));
        if (ele.isDisplayed()) {
          isVisible = true;
          break;
        }
      } catch (Exception e) {
        swipe();
      }
    }
    Assert.assertTrue(isVisible);
  }

  public static void swipeToTextAndTap(String productName) {
    int maxScroll = 10;
    for (int i = 0; i < maxScroll; i++) {
      try {
        WebElement ele = driver.findElement(
            AppiumBy.xpath("//android.widget.TextView[@text=\"" + productName + "\"]"));
        if (ele.isDisplayed()) {
          ele.click();
          return;
        }
      } catch (Exception e) {
        swipe();
      }
    }
  }
}