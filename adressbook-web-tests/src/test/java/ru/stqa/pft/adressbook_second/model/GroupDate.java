package ru.stqa.pft.adressbook_second.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupDate {
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "group_name")
  private String name;

  @Expose
  @Column(name = "group_header")
  @Type(type =  "text")
  private String header;

  @Expose
  @Column(name = "group_footer")
  @Type(type =  "text")
  private String footer;

  @Override
  public String toString() {
    return "GroupDate{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupDate groupDate = (GroupDate) o;
    return id == groupDate.id &&
            Objects.equals(name, groupDate.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
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
}
