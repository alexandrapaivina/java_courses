package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

public class GroupCreateTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupDate("nameGroup12", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
}
