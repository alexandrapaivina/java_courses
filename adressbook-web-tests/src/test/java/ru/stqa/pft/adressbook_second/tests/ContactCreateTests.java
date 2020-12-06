package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() throws InterruptedException {
    app.goTo().homePage();
    List<ContactDate> before = app.contact().list();
    ContactDate contact = new ContactDate("Test name", "Middle name",
            "Last name", "Krasnodar", "89998887766", "test@test.ru", "nameGroup12");
    app.contact().create(contact);
    Thread.sleep(1000);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(before.size() + 1, after.size());

    before.add(contact);
    Comparator<ContactDate> contactDateComparatorLambda =
            (c1, c2) -> c1.getFirstname().compareTo(c2.getFirstname());
    Collections.sort(before, contactDateComparatorLambda);
    Collections.sort(after, contactDateComparatorLambda);
    Assert.assertEquals(before, after);
  }
}