package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;
import ru.stqa.pft.adressbook_second.model.GroupDate;
import ru.stqa.pft.adressbook_second.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactInGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.db().addContact(new ContactDate().withFirstname("Test name").withMiddlename("Middle name").withLastname("Last name").withAdress("Krasnodar")
              .withMobilephone("89998887766").withEmail("test@test.ru"));
      app.goTo().refreshPage();
      Thread.sleep(2000);
    }
    if (app.db().groups().size() == 0) {
      app.db().addGroup(new GroupDate().withName("Test group").withHeader("Test header").withFooter("Test footer"));
      app.goTo().refreshPage();
      Thread.sleep(2000);
    }
  }

  @Test
  public void addContactInGroup() {
    Contacts before = app.db().contacts();
    ContactDate selectContact = before.iterator().next();
    GroupDate group = getGroupWithoutContact(selectContact);
    app.goTo().refreshPage();
    app.contact().addInGroup(selectContact, group);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(selectContact).withAdded(selectContact.inGroup(group))));
  }

  public GroupDate getGroupWithoutContact(ContactDate selectContact) {

    Set<GroupDate> groupsContact = selectContact.getGroups();
    if (groupsContact.size() == app.db().groups().size()) {
      app.db().addGroup(new GroupDate().withName("Test group").withHeader("Test header").withFooter("Test footer"));
    }

    List<GroupDate> allGroups = List.copyOf(app.db().groups());
    for (int i = 0; i < allGroups.size(); i++) {
      if (!groupsContact.contains(allGroups.get(i))) {
        return allGroups.get(i);
      }
    }
    return null;
  }
}
