package ru.stqa.pft.adressbook_second.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;
import ru.stqa.pft.adressbook_second.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if(app.db().groups().size() == 0){
      app.group().create(new GroupDate().withName("nameGroup12"));
    }
  }

  @Test
  public void testsGroupModification() {
    Groups before = app.db().groups();
    GroupDate modifiedGroup = before.iterator().next();
    GroupDate group = new GroupDate()
            .withName("nameGroup12").withFooter("footer222").withHeader("header222")
            .withId(modifiedGroup.getId());
    app.group().modify(group);
    assertThat(app.group().getGroupCount(), equalTo(before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    verifyGroupListInUI();
  }


}
