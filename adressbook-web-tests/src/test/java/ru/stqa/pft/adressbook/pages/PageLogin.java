package ru.stqa.pft.adressbook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends Page{

  public PageLogin(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[name='user']")
  public WebElement userName;

  @FindBy(css = "[name='pass']")
  public WebElement password;

  @FindBy(css = "[type='submit']")
  public WebElement login;
}
