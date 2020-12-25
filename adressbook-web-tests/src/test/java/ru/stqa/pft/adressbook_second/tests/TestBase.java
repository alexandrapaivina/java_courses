package ru.stqa.pft.adressbook_second.tests;

import org.openqa.selenium.remote.BrowserType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.adressbook_second.appmanager.ApplicationManager;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;
import ru.stqa.pft.adressbook_second.model.GroupDate;
import ru.stqa.pft.adressbook_second.model.Groups;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestBase {

  //Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static ApplicationManager app;

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

  public void verifyGroupListInUI() {
    //System.setProperty("verifyUI","true");
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupDate()
              .withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyContactListInUI() {
    System.setProperty("verifyUI", "true");
    if (Boolean.getBoolean("verifyUI")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream().map((c) -> new ContactDate()
              .withId(c.getId()).withFirstname(c.getFirstName()).withLastname(c.getLastName()))
              .collect(Collectors.toSet())));
    }
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
