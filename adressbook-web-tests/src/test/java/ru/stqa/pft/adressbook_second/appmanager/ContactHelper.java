package ru.stqa.pft.adressbook_second.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;

import java.util.List;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.partialLinkText;

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
    initContactModificationById(contact.getId());
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
    type(name("firstname"), contactDate.getFirstName());
    type(name("middlename"), contactDate.getMiddleName());
    type(name("lastname"), contactDate.getLastName());
    type(name("address"), contactDate.getAdress());
    type(name("mobile"), contactDate.getMobilePhone());
    type(name("email"), contactDate.getEmail());
    type(name("work"), contactDate.getWorkPhone());
    type(name("home"), contactDate.getHomePhone());
    attach(name("photo"), contactDate.getPhoto());

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
      String allPhones = element.findElement(By.cssSelector("td:nth-of-type(6)")).getText();
      String allEmail = element.findElement(By.cssSelector("td:nth-of-type(5)")).getText();
      String address = element.findElement(By.cssSelector("td:nth-of-type(4)")).getText();
      ContactDate contact = new ContactDate().withId(id).withFirstname(firstName).withLastname(lastName)
              .withAllPhones(allPhones).withAllEmail(allEmail).withAdress(address);



      contacts.add(contact);
    }
    return contacts;
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public ContactDate infoFromEditForm(ContactDate contact) {
    initContactModificationById(contact.getId());


    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String adress = wd.findElement(By.name("address")).getAttribute("value");

    wd.navigate().back();
    return new ContactDate().withId(contact.getId()).withHomephone(home).withMobilephone(mobile)
            .withWorkphone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAdress(adress);
  }
}
