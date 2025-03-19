package utils;

import java.io.FileInputStream;
import org.yaml.snakeyaml.Yaml;
import java.util.Map;

public class ConfigReader {
  private static Map<String, Object> config;

  static {
    try (FileInputStream inputStream = new FileInputStream(
        "src/test/java/configuration/config.yaml")) {
      if (inputStream == null) {
        throw new RuntimeException("config.yaml not found in resources folder");
      }
      Yaml yaml = new Yaml();
      config = yaml.load(inputStream);
    } catch (Exception e) {
      throw new RuntimeException("Failed to load config.yaml file.", e);
    }
  }

  public static String getConfigValue(String key) {
    Map<String, Object> appiumConfig = (Map<String, Object>) config.get("appium");

    if (appiumConfig != null && appiumConfig.containsKey(key)) {
      return appiumConfig.get(key).toString();
    }
    return null;
  }

}
