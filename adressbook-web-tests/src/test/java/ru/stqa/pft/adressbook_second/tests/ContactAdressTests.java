package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAdressTests extends TestBase {

  @Test
  public void testContactAdress() {
    app.goTo().homePage();
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAdress(), equalTo(contactInfoFromEditForm.getAdress()));
  }


}
