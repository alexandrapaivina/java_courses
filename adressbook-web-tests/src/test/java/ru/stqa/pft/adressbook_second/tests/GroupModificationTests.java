package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.GroupDate;

public class GroupModificationTests extends TestBase {

  @Test
  public void testsGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereGroup()){
      app.getGroupHelper().createGroup(new GroupDate("nameGroup12", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initModificayion();
    app.getGroupHelper().fillGroupForm(new GroupDate("nameGroup12", "test header222", "comment footer222"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

}
