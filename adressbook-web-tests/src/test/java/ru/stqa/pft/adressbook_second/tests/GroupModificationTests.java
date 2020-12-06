package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.Set;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupDate().withName("nameGroup12"));
    }
  }

  @Test
  public void testsGroupModification() {
    Set<GroupDate> before = app.group().all();
    GroupDate modifiedGroup = before.iterator().next();
    GroupDate group = new GroupDate()
            .withName("nameGroup12").withFooter( "footer222").withHeader("header222")
            .withId(modifiedGroup.getId());
    app.group().modify(group);
    Set<GroupDate> after = app.group().all();
    Assert.assertEquals(before.size(), after.size());

    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
