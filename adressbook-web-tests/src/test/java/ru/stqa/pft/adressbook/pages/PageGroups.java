package ru.stqa.pft.adressbook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageGroups extends Page{
  public PageGroups(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[name='new']")
  public WebElement create;
}
