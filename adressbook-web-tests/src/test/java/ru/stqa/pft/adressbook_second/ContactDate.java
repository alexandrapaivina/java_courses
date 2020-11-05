package ru.stqa.pft.adressbook_second;

public class ContactDate {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String adress;
  private final String mobilephone;
  private final String email;

  public ContactDate(String firstname, String middlename, String lastname, String adress, String mobilephone, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.adress = adress;
    this.mobilephone = mobilephone;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAdress() {
    return adress;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getEmail() {
    return email;
  }
}
