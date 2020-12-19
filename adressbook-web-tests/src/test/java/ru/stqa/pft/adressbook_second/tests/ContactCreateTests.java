package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

import static java.util.Collections.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() throws InterruptedException {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/java/ru/stqa/pft/adressbook_second/resources/unnamed.jpg");
    ContactDate contact = new ContactDate().withFirstname("Test nameHHH").withMiddlename("Middle name").withLastname("Last name")
            .withAdress("Krasnodar").withEmail("89998887766").withEmail("test@test.ru").withGroup("nameGroup12").withHomephone("777")
            .withWorkphone("999").withMobilephone("333").withPhoto(photo);
    app.contact().create(contact);
    app.goTo().homePage();
    Thread.sleep(1000);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    assertThat(after.size(), equalTo(before.size() + 1));
  }
}