package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupDate().withName("nameGroup12"));
    }
  }

  @Test
  public void testsGroupModification() {
    List<GroupDate> before = app.group().list();
    int index = before.size() - 1;
    GroupDate group = new GroupDate()
            .withName("nameGroup12").withFooter( "footer222").withHeader("header222")
            .withId(before.get(index).getId());
    app.group().modify(index, group);
    List<GroupDate> after = app.group().list();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
