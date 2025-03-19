package utils;

public class GenericMethods {
  public static void staticWait(int timeToWaitInSecond){
    try {
      Thread.sleep(timeToWaitInSecond * 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}