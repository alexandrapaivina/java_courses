package ru.stqa.pft.adressbook_second.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook_second.model.ContactDate;

import java.util.List;

public class ContactDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.contact().list().size() == 0){
      app.contact().create(new ContactDate("Test name", "Middle name",
              "Last name", "Krasnodar", "89998887766", "test@test.ru","nameGroup12"));
    }
  }

  @Test
  public void testContactDelete() throws InterruptedException {
    List<ContactDate> before = app.contact().list();
    int index = before.size() - 1;
    app.goTo().homePage();
    app.contact().delete(index);
    Thread.sleep(1000);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(before.size() - 1, after.size());

    before.remove(index);
    Assert.assertEquals(after, before);
  }
}
