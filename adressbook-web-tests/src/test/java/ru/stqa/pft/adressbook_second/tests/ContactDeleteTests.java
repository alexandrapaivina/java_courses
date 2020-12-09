package ru.stqa.pft.adressbook_second.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withFirstname("Test name").withMiddlename("Middle name").withLastname("Last name").withAdress("Krasnodar")
              .withMobilephone("89998887766").withEmail("test@test.ru").withGroup("nameGroup12"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactDelete() throws InterruptedException {
    Contacts before = app.contact().all();
    ContactDate deletedContact = before.iterator().next();
    app.goTo().homePage();
    app.contact().delete(deletedContact);
    Thread.sleep(1000);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
