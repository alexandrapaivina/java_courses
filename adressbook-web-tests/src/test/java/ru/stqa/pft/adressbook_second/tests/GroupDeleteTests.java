package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

import java.util.List;

public class GroupDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupDate().withName("nameGroup12"));
    }
  }

  @Test
  public void testGroupDelete() {
    List<GroupDate> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupDate> after = app.group().list();
    Assert.assertEquals(before.size() - 1, after.size() );

    before.remove(index);
    Assert.assertEquals(after, before);
  }
}
