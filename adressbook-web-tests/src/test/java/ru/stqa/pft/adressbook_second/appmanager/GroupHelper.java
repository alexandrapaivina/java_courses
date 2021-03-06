package ru.stqa.pft.adressbook_second.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.adressbook_second.model.GroupDate;
import ru.stqa.pft.adressbook_second.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  private Groups groupCash = null;

  ///Основные действия с группами
  public void create(GroupDate group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCash = null;
    returnToGroupPage();
  }

  public void modify(GroupDate group) {
    selectGroupById(group.getId());
    initModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCash = null;
    returnToGroupPage();
  }

  public void delete(GroupDate group) {
    selectGroupById(group.getId());
    initDeleteGroup();
    groupCash = null;
    returnToGroupPage();
  }

  ///Вспомогательные функции
  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupDate groupDate) {
    type(By.name("group_name"), groupDate.getName());
    type(By.name("group_header"), groupDate.getHeader());
    type(By.name("group_footer"), groupDate.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void initDeleteGroup() {
    click(By.name("delete"));
  }

  public boolean isThereGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Groups all() {
    if(groupCash!=null){
      return new Groups(groupCash);
    }
    groupCash = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCash.add(new GroupDate().withId(id).withName(name));
    }
    return new Groups(groupCash);
  }
}
