package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase{

  @Test
  public void testContactEmail(){
    app.goTo().homePage();
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmail(), equalTo(mergeEmail(contactInfoFromEditForm)));
  }

  private String mergeEmail(ContactDate contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }


}
