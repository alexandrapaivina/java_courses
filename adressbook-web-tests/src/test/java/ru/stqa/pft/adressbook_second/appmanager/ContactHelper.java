package ru.stqa.pft.adressbook_second.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook_second.model.ContactDate;

import java.util.ArrayList;
import java.util.List;

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
    initContactEdit();
    fillContactForm(contact,false);
    initContactUpdate();
    returnToContactPage();
  }

  public void delete(int index) {
    selectContact(index);
    initDeleteContact();
    acceptAllertDeleteContact();
    returnToContactPage();
  }

  ///Вспомогательные функции
  public void returnToContactPage(){
    click(By.linkText("home"));
  }

  public void fillContactForm(ContactDate contactDate, boolean creation) {
    type(By.name("firstname"), contactDate.getFirstname());
    type(By.name("middlename"), contactDate.getMiddlename());
    type(By.name("lastname"), contactDate.getLastname());
    type(By.name("address"), contactDate.getAdress());
    type(By.name("mobile"), contactDate.getMobilephone());
    type(By.name("email"), contactDate.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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


  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactDate> list() {
    List<ContactDate> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name = 'entry']"));
    for (WebElement element : elements) {
      //int id = Integer.parseInt(element.findElement(By.cssSelector("input")).getAttribute("value"));
      String firstName = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
      ContactDate contact = new ContactDate().withFirstname(firstName).withLastname(lastName);
      contacts.add(contact);
    }
    return contacts;
  }
}
