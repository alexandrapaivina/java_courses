package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactDate("Test name", "Middle name",
            "Last name", "Krasnodar", "89998887766", "test@test.ru","nameGroup12"));
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(before + 1 ,after );
  }
}