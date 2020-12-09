package ru.stqa.pft.adressbook_second.appmanager;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.name;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  ///Основные действия с группами
  public void create(ContactDate contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToContactPage();
  }

  public void modify(ContactDate contact) {
    initContactEdit(contact.getId());
    fillContactForm(contact, false);
    initContactUpdate();
    returnToContactPage();
  }

  public void delete(ContactDate contact) {
    selectContactById(contact.getId());
    initDeleteContact();
    acceptAllertDeleteContact();
    returnToContactPage();
  }

  ///Вспомогательные функции
  public void returnToContactPage() {
    click(By.linkText("home"));
  }

  public void fillContactForm(ContactDate contactDate, boolean creation) {
    type(name("firstname"), contactDate.getFirstname());
    type(name("middlename"), contactDate.getMiddlename());
    type(name("lastname"), contactDate.getLastname());
    type(name("address"), contactDate.getAdress());
    type(name("mobile"), contactDate.getMobilephone());
    type(name("email"), contactDate.getEmail());

    if (creation) {
      new Select(wd.findElement(name("new_group"))).selectByVisibleText(contactDate.getGroup());
    } else Assert.assertFalse(isElementPresent(By.name("new_group")));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContactById(int index) {
    wd.findElement(By.cssSelector("input[id='" + index + "']")).click();
  }

  public void initDeleteContact() {
    click(By.cssSelector("input[value='Delete']"));
  }

  public void acceptAllertDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void initContactEdit(int index) {
    click(By.cssSelector("[href = 'edit.php?id=" + index + "']"));
  }

  public void initContactUpdate() {
    click(name("update"));
  }


  public boolean isThereContact() {
    return isElementPresent(name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name = 'entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.cssSelector("input")).getAttribute("value"));
      String firstName = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
      ContactDate contact = new ContactDate().withId(id).withFirstname(firstName).withLastname(lastName);
      contacts.add(contact);
    }
    return contacts;
  }
}
