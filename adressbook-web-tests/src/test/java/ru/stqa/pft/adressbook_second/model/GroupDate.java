package ru.stqa.pft.adressbook_second.model;

import com.google.gson.annotations.Expose;
import com.sun.istack.NotNull;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupDate {
  @XStreamOmitField
  @Id
  @Column(name = "group_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "group_name", nullable = false)
  private String name;

  @ManyToMany(mappedBy = "groups")
  private Set<ContactDate> contacts = new HashSet<ContactDate>();

  @Expose
  @Column(name = "group_header", nullable = false)
  @Type(type =  "text")
  private String header;

  @Expose
  @Column(name = "group_footer", nullable = false)
  @Type(type =  "text")
  private String footer;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupDate groupDate = (GroupDate) o;
    return id == groupDate.id &&
            Objects.equals(name, groupDate.name) &&
            Objects.equals(header, groupDate.header) &&
            Objects.equals(footer, groupDate.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, header, footer);
  }

  @Override
  public String toString() {
    return "GroupDate{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  public int getId() {
    return id;
  }

  public GroupDate withName(String name) {
    this.name = name;
    return this;
  }

  public GroupDate withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupDate withId(int id) {
    this.id = id;
    return this;
  }

  public GroupDate withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public Set<ContactDate> getContacts() {
    return new Contacts(contacts);
  }
}
