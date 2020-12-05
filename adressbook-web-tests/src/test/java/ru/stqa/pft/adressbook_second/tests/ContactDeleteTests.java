package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

import java.util.List;

public class ContactDeleteTests extends TestBase {

  @Test
  public void testContactDelete() throws InterruptedException {
    app.getNavigationHelper().gotoHomePage();
    List<ContactDate> before = app.getContactHelper().getContactList();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactDate("Test name", "Middle name",
              "Last name", "Krasnodar", "89998887766", "test@test.ru", "nameGroup12"));
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initDeleteContact();
    app.getContactHelper().acceptAllertDeleteContact();
    app.getNavigationHelper().gotoHomePage();
    Thread.sleep(1000);
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size() - 1, after.size());

    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }
}
