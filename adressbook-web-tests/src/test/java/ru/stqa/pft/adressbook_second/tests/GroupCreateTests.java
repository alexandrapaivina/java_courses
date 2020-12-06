package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.Set;

public class GroupCreateTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Set<GroupDate> before = app.group().all();
    GroupDate group = new GroupDate().withName("nameGroup11");
    app.group().create(group);
    Set<GroupDate> after = app.group().all();
    Assert.assertEquals(before.size() + 1, after.size());

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
