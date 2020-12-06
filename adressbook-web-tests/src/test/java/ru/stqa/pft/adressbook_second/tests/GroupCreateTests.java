package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.Comparator;
import java.util.List;

public class GroupCreateTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    List<GroupDate> before = app.group().list();
    GroupDate group = new GroupDate("nameGroup11", null, null);
    app.group().create(group);
    List<GroupDate> after = app.group().list();
    Assert.assertEquals(before.size() + 1, after.size());

    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
