package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().createContact(new ContactDate("Test name", "Middle name",
            "Last name", "Krasnodar", "89998887766", "test@test.ru","nameGroup12"));
  }
}