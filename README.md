# Spotify iOS Automation Framework  

## **Overview**  
This repository contains an **Appium-based mobile automation framework** for testing the **Spotify iOS application**. The framework is developed using **Java, TestNG, and Appium** and supports **data-driven testing** with **TestNG DataProviders**.  

## **Tech Stack**  
- **Programming Language:** Java  
- **Automation Tool:** Appium  
- **Test Runner:** TestNG  
- **Dependency Management:** Maven  
- **Reporting:** Extent Reports  
- **Configuration Management:** YAML  

## **Project Structure**  
Spotify-iOS-Automation/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   ├── BaseEngine.java
│   │   │   ├── pages/
│   │   │   │   ├── EmailLoginPage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── SplashScreen.java
│   │   │   ├── utils/
│   │   │   │   ├── ConfigReader.java
│   │   │   │   ├── CustomMethods.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── configuration/
│   │   │   │   ├── config.yaml
│   │   │   ├── ScreenShots/
│   │   │   ├── testdata/
│   │   │   │   ├── LoginData.java
│   │   │   ├── tests/
│   │   │   │   ├── AppTests.java
│
│── pom.xml
│── testng.xml
│── README.md


## **Setup & Installation**  

### **Prerequisites**  
1. Install **Java 20** (as per `pom.xml`).
2. Install **Appium** and start the Appium server.  
   ```sh
   npm install -g appium
   appium
