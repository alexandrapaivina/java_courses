package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.Set;

public class GroupDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupDate().withName("nameGroup12"));
    }
  }

  @Test
  public void testGroupDelete() {
    Set<GroupDate> before = app.group().all();
    GroupDate deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupDate> after = app.group().all();
    Assert.assertEquals(before.size() - 1, after.size() );


    before.remove(deletedGroup);
    Assert.assertEquals(after, before);
  }
}
