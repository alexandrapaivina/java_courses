package ru.stqa.pft.adressbook_second.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Group;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactDate().withFirstname("Test name").withMiddlename("Middle name").withLastname("Last name").withAdress("Krasnodar")
              .withMobilephone("89998887766").withEmail("test@test.ru"));
      app.goTo().homePage();
    }
    if (app.db().groups().size() == 0) {
      app.db().addGroup(new GroupDate().withName("Test group").withHeader("Test header").withFooter("Test footer"));
      app.goTo().refreshPage();
      Thread.sleep(1000);
    }
  }

  @Test
  public void deleteContactFromGroup() {
    Contacts before = app.db().contacts();
    ContactDate selectContact = before.iterator().next();
    GroupDate group = getGroupWithContact(selectContact);
    app.goTo().refreshPage();
    app.contact().deleteFromGroup(selectContact, group);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(selectContact).withAdded(selectContact.deleteGroup(group))));
  }

  public GroupDate getGroupWithContact(ContactDate selectContact) {

    if (selectContact.getGroups().size() == 0) {
      GroupDate group = app.db().groups().iterator().next();
      app.contact().addInGroup(selectContact, group);
      app.goTo().homePage();
      return group;
    }

    List<GroupDate> allGroups = List.copyOf(app.db().groups());
    for (int i = 0; i < allGroups.size(); i++) {
      if (selectContact.getGroups().contains(allGroups.get(i))) {
        return allGroups.get(i);
      }
    }
    return null;
  }

}
