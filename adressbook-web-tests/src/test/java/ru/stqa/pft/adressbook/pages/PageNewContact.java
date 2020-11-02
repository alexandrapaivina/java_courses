package ru.stqa.pft.adressbook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageNewContact extends Page {


  public PageNewContact(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[name='firstname']")
  public WebElement firstName;

  @FindBy(css = "[name='middlename']")
  public WebElement midleName;

  @FindBy(css = "[name='lastname']")
  public WebElement lastName;

  @FindBy(css = "[name='address']")
  public WebElement adress;

  @FindBy(css = "[name='email']")
  public WebElement email;

  @FindBy(css = "[name='mobile']")
  public WebElement phoneMobile;

  @FindBy(css = "[value='Enter']")
  public WebElement create;
}
