package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeClass;
import ru.stqa.pft.adressbook.app.Application;

public class TestBase2 {
  public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
  public Application app;

  @BeforeClass
  public void start() {
    if (tlApp.get() != null) {
      app = tlApp.get();
      return;
    }

    app = new Application();
    tlApp.set(app);

    Runtime.getRuntime().addShutdownHook(
            new Thread(() -> {
              app.quit();
              app = null;
            }));
  }
}
