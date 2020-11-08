package ru.stqa.pft.adressbook_second.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoHomePage() {
    click(By.cssSelector("a[href='./']"));
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
}
