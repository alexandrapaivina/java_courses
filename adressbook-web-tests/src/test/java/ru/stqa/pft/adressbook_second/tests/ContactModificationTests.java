package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactEdit();
    app.getContactHelper().fillContactForm(new ContactDate("Test name22", "Middle name22",
            "Last name22", "Krasnoda22", "8999888776622",
            "test@test.ru22"));
    app.getContactHelper().initContactUpdate();
  }

}
