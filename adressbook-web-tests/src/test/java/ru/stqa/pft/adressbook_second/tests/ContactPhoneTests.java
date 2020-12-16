package ru.stqa.pft.adressbook_second.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhone() throws InterruptedException {
    app.goTo().homePage();
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactDate contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }


}
