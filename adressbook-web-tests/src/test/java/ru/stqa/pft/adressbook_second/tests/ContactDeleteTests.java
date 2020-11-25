package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

public class ContactDeleteTests extends TestBase {

  @Test
  public void testContactDelete() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if(! app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactDate("Test name", "Middle name",
              "Last name", "Krasnodar", "89998887766", "test@test.ru","nameGroup12"));
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initDeleteContact();
    app.getContactHelper().acceptAllertDeleteContact();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    System.out.println(before + "BBBBBBBBBBBBBBBBBBB" + after);
    Assert.assertEquals(before - 1 ,after );
  }
}
