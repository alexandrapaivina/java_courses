package ru.stqa.pft.adressbook.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.pft.adressbook.pages.Page;

public class TopMenu extends Page {

  public TopMenu(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[onclick*='logout']")
  public WebElement logout;

  @FindBy(css = "[href='group.php']")
  public WebElement groups;

  @FindBy(css = "[href='edit.php']")
  public WebElement addContact;

  @FindBy(css = "[href='./']")
  public WebElement home;
}
