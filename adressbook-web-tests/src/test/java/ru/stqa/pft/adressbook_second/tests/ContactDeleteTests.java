package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase {

  @Test
  public void testContactDelete() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initDeleteContact();
    app.getContactHelper().acceptAllertDeleteContact();
  }
}
