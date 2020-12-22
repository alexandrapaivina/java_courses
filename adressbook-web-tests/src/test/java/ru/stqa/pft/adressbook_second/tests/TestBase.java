package ru.stqa.pft.adressbook_second.tests;

import org.openqa.selenium.remote.BrowserType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.adressbook_second.appmanager.ApplicationManager;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

  //Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static  ApplicationManager app;

  static {
    try {
      app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws InterruptedException, IOException {
    System.setProperty("webdriver.chrome.driver", "/Users/dev/AuxiliaryExecutables/chromedriver");
    System.setProperty("webdriver.gecko.driver", "/Users/dev/AuxiliaryExecutables//geckodriver");
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

/*
  @BeforeMethod
  public void logTestStart(Method m){
    logger.info("Start test" + m.getName());
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop test" + m.getName());
  }*/
}
