package ru.stqa.pft.adressbook_second.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.adressbook_second.appmanager.ApplicationManager;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/Users/dev/AuxiliaryExecutables/chromedriver");
    System.setProperty("webdriver.gecko.driver", "/Users/dev/AuxiliaryExecutables//geckodriver");
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }
}
