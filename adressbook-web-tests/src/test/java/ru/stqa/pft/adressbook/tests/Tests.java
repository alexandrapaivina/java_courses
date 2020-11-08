package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.adressbook.model.Contact;
import ru.stqa.pft.adressbook.model.Group;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.User;

public class Tests extends TestBase2 {

  @BeforeMethod
  public void preconditions() {
    app.open("http://localhost/addressbook/index.php");
    app.login(new User("admin", "secret"));
  }

  @Test
  public void addGroup() {
    Group group = app.generateGroup("рус");
    app.openGroups();
    app.createGroup(group);
    Assert.assertTrue(app.availabilityText("A new group has been entered into the address book."));
    app.openGroups();
    Assert.assertTrue(app.availabilityText(group.getName()));
  }

  @Test
  public void addContact() {
    Contact contact = app.generateContact("рус");
    app.openNewContact();
    app.createContact(contact);
    app.openHome();
    Assert.assertTrue(app.availabilityText(contact.getFirstName()));
  }

  @AfterMethod
  public void postconditions() {
    app.loguot();
  }

}
