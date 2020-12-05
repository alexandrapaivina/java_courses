package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() throws InterruptedException {
    app.getNavigationHelper().gotoHomePage();
    List<ContactDate> before = app.getContactHelper().getContactList();
    if(! app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactDate("Test name", "Middle name",
              "Last name", "Krasnodar", "89998887766", "test@test.ru","nameGroup12"));
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactEdit();

    ContactDate contact = new ContactDate("Test77","Last77");
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().initContactUpdate();
    app.getNavigationHelper().gotoHomePage();
    Thread.sleep(1000);
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(0);
    before.add(contact);
    Comparator<ContactDate> contactDateComparatorLambda      =
            (c1, c2) -> c1.getFirstname().compareTo(c2.getFirstname());
    Collections.sort(before, contactDateComparatorLambda);
    Collections.sort(after, contactDateComparatorLambda);
    Assert.assertEquals(before, after);
  }

}
