package ru.stqa.pft.adressbook_second.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;
import ru.stqa.pft.adressbook_second.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Groups before = app.group().all();
    GroupDate deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    Assert.assertEquals(before.size() - 1, after.size() );
    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
