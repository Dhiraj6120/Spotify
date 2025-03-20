package testdata;

import org.testng.annotations.DataProvider;

public class LoginData {

  @DataProvider(name = "loginData")
  public static Object[][] getLoginData() {
    return new Object[][] {
        {"user1@example.com", "password123"},
        {"user2@example.com", "password456"},
        {"user3@example.com", "password789"}
    };
  }
}
