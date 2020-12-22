package ru.stqa.pft.adressbook_second.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactDate {

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstName;

  @Expose
  @Column(name = "middlename")
  private String middleName;

  @Expose
  @Column(name = "lastname")
  private String lastName;

  @Transient
  private String adress;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;

  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Expose
  @Transient
  private String group;

  @Transient
  private String allPhones;

  @Transient
  private String allEmail;

  @Transient
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactDate that = (ContactDate) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(mobilePhone, that.mobilePhone) &&
            Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, middleName, lastName, mobilePhone, email);
  }

  @Override
  public String toString() {
    return "ContactDate{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", middleName='" + middleName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", adress='" + adress + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            '}';
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

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmail() {
    return allEmail;
  }

  public File getPhoto() {
    return new File(photo);
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

  public ContactDate withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactDate withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }


  public ContactDate withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactDate withAllEmail(String allEmail) {
    this.allEmail = allEmail;
    return this;
  }

  public ContactDate withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }


}
