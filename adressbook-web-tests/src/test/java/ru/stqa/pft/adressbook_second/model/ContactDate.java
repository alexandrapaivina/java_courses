package ru.stqa.pft.adressbook_second.model;

import java.util.Objects;

public class ContactDate {

  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String adress;
  private final String mobilephone;
  private final String email;
  private final String group;

  public ContactDate(String firstname, String middlename, String lastname,
                     String adress, String mobilephone, String email, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.adress = adress;
    this.mobilephone = mobilephone;
    this.email = email;
    this.group = group;
  }

  @Override
  public String toString() {
    return "ContactDate{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactDate that = (ContactDate) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }

  public ContactDate(String firstname, String lastname) {
    this.firstname = firstname;
    this.middlename = null;
    this.lastname = lastname;
    this.adress = null;
    this.mobilephone = null;
    this.email = null;
    this.group = null;
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

  public String getGroup() {
    return group;
  }
}
