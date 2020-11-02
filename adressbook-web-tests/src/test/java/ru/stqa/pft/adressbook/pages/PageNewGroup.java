package ru.stqa.pft.adressbook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageNewGroup extends Page{
  public PageNewGroup(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[name='group_name']")
  public WebElement groupName;

  @FindBy(css = "[name='group_header']")
  public WebElement groupHeader;

  @FindBy(css = "[name='group_footer']")
  public WebElement groupFooter;

  @FindBy(css = "[name='submit']")
  public WebElement create;
}
