package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.List;

public class GroupDeleteTests extends TestBase {

  @Test
  public void testGroupDelete() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupDate("nameGroup12", null, null));
    }
    List<GroupDate> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initDeleteGroup();
    app.getNavigationHelper().gotoGroupPage();
    List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size() + 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }
}
