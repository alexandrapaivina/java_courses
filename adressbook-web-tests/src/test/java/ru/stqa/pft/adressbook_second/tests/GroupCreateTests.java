package ru.stqa.pft.adressbook_second.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;
import ru.stqa.pft.adressbook_second.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupCreateTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupDate group = new GroupDate().withName("nameGroup11");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(
            group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    assertThat(after.size(), equalTo(before.size() + 1));
  }
}
