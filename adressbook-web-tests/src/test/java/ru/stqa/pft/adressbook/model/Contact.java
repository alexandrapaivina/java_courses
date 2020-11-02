package ru.stqa.pft.adressbook.model;

public class Contact {
  private final String firstName;
  private final String midleName;
  private final String lastName;
  private final String adress;
  private final String email;
  private final String phone;

  public Contact(String firstName, String midleName, String lastName, String adress, String email, String phone) {
    this.firstName = firstName;
    this.midleName = midleName;
    this.lastName = lastName;
    this.adress = adress;
    this.email = email;
    this.phone = phone;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMidleName() {
    return midleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAdress() {
    return adress;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }
}
