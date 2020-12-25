package ru.stqa.pft.adressbook_second.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void homePage() {
    /*if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.cssSelector("a[href='./']"));*/
    wd.get("http://localhost/addressbook/index.php");
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).equals("groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void refreshPage() {
    wd.navigate().refresh();
  }
}
