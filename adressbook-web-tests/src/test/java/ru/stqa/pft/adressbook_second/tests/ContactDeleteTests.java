package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

public class ContactDeleteTests extends TestBase {

  @Test
  public void testContactDelete() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactDate("Test name", "Middle name",
              "Last name", "Krasnodar", "89998887766", "test@test.ru","nameGroup12"));
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initDeleteContact();
    app.getContactHelper().acceptAllertDeleteContact();
  }
}
