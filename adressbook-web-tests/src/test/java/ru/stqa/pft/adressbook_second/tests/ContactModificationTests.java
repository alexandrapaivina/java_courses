package ru.stqa.pft.adressbook_second.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.interactions.ContextClickAction;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if(app.db().contacts().size() == 0){
      app.contact().create(new ContactDate().withFirstname("Test name").withMiddlename("Middle name").withLastname("Last name").withAdress("Krasnodar")
              .withMobilephone("89998887766").withEmail("test@test.ru").withGroup("nameGroup12"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() throws InterruptedException {
    Contacts before = app.db().contacts();
    ContactDate modifiedContact = before.iterator().next();
    ContactDate contact = new ContactDate().withId(modifiedContact.getId()).withFirstname("FIRST NAME2").withLastname("Last name");
    Thread.sleep(1000);
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertThat(before.size(), equalTo(after.size()));
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
