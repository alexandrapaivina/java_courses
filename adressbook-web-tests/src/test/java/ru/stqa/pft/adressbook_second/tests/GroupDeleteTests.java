package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

public class GroupDeleteTests extends TestBase {

  @Test
  public void testGroupDelete() {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereGroup()){
      app.getGroupHelper().createGroup(new GroupDate("nameGroup12", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initDeleteGroup();
  }
}
