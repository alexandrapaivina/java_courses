package ru.stqa.pft.adressbook_second.model;

import java.util.Objects;

public class ContactDate {

  private int id = Integer.MAX_VALUE;


  private String firstName;
  private String middleName;
  private String lastName;
  private String adress;
  private String mobilePhone;
  private String workPhone;
  private String homePhone;
  private String email;
  private String group;


  @Override
  public String toString() {
    return "ContactDate{" +
            "id=" + id +
            ", firstname='" + firstName + '\'' +
            ", lastname='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactDate that = (ContactDate) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAdress() {
    return adress;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public ContactDate withWorkphone(String workphone) {
    this.workPhone = workphone;
    return this;
  }

  public ContactDate withHomephone(String homephone) {
    this.homePhone = homephone;
    return this;
  }

  public ContactDate withFirstname(String firstname) {
    this.firstName = firstname;
    return this;
  }

  public ContactDate withMiddlename(String middlename) {
    this.middleName = middlename;
    return this;
  }

  public ContactDate withLastname(String lastname) {
    this.lastName = lastname;
    return this;
  }

  public ContactDate withAdress(String adress) {
    this.adress = adress;
    return this;
  }

  public ContactDate withMobilephone(String mobilephone) {
    this.mobilePhone = mobilephone;
    return this;
  }

  public ContactDate withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactDate withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactDate withId(int id) {
    this.id = id;
    return this;
  }
}
