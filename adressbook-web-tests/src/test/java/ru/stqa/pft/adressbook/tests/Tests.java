package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.app.Group;
import ru.stqa.pft.adressbook.model.User;

public class Tests extends TestBase{

  @BeforeMethod
  public void preconditions(){
    app.open("http://localhost/addressbook/index.php");
    app.login(new User("admin","secret"));
  }


  @Test
  public void firstTest(){
    Group group = app.generateGroup();
    app.openGroups();
    app.createGroup(group);
    //Assert.assertTrue(app.availabilityText("A new group has been entered into the address book."));
    app.openGroups();
    Assert.assertTrue(app.availabilityText(group.getName()));
  }


  @AfterMethod
  public void postconditions(){
    app.loguot();
  }

}
