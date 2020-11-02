package ru.stqa.pft.adressbook.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.adressbook.elements.TopMenu;
import ru.stqa.pft.adressbook.model.User;
import ru.stqa.pft.adressbook.pages.PageNewGroup;
import ru.stqa.pft.adressbook.pages.PageGroups;
import ru.stqa.pft.adressbook.pages.PageLogin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Application {

  private WebDriver driver;
  private WebDriverWait wait;
  private PageLogin loginPage;
  private TopMenu topMenu;
  private PageNewGroup pageNewGroup;
  private PageGroups pageGroups;


  public Application() {
    System.setProperty("webdriver.chrome.driver", "/Users/dev/AuxiliaryExecutables/chromedriver");
    driver = new ChromeDriver();
    loginPage = new PageLogin(driver);
    topMenu = new TopMenu(driver);
    pageNewGroup = new PageNewGroup(driver);
    pageGroups = new PageGroups(driver);
  }

  public void quit() {
    driver.quit();
    driver = null;
  }

  //Открытие стартовой страницы приложения
  public void open(String url) {
    driver.get(url);
  }

  //Авторизация пользователя
  public void login(User user) {
      loginPage.userName.sendKeys(user.getUsername());
      loginPage.password.sendKeys(user.getPassword());
      loginPage.login.click();
  }

  //Деавторизация пользователя
  public void loguot(){
    topMenu.logout.click();
  }

  public void openGroups() {
    topMenu.groups.click();
  }


  //Создание группы
  public void createGroup(Group group){
    topMenu.groups.click();
    pageGroups.create.click();
    pageNewGroup.groupName.sendKeys(group.getName());
    pageNewGroup.groupHeader.sendKeys(group.getHeader());
    pageNewGroup.groupFooter.sendKeys(group.getFooter());
    pageNewGroup.create.click();
  }

  //Генерация уникальной группы
  public Group generateGroup(){
    String number = generateNumber();
    return new Group("testName"+ number,"header"+ number,
            "footer"+ number);
  }

  public String generateNumber(){
    DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
    Date today = Calendar.getInstance().getTime();
    String number = df.format(today);
    return number;
  }

  //Проверяет наличие текста на странице
  public Boolean availabilityText(String text){
    if(driver.getPageSource().contains(text)==Boolean.TRUE)
      return Boolean.TRUE;
    else return Boolean.FALSE;
  }

}
