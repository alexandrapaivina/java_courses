package ru.stqa.pft.adressbook_second.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook_second.model.ContactDate;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactDate contactDate) {
    type(By.name("firstname"), contactDate.getFirstname());
    type(By.name("middlename"),contactDate.getMiddlename());
    type(By.name("lastname"),contactDate.getLastname());
    type(By.name("address"),contactDate.getAdress());
    type(By.name("mobile"),contactDate.getMobilephone());
    type(By.name("email"),contactDate.getEmail());
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initDeleteContact() {
    click(By.cssSelector("input[value='Delete']"));
  }

  public void acceptAllertDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void initContactEdit() {
    click(By.cssSelector("[title='Edit']"));
  }

  public void initContactUpdate() {
    click(By.name("update"));
  }
}
