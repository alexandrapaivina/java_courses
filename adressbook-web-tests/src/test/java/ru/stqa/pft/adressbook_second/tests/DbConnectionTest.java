package ru.stqa.pft.adressbook_second.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Group;
import ru.stqa.pft.adressbook_second.model.GroupDate;
import ru.stqa.pft.adressbook_second.model.Groups;

import java.sql.*;

public class DbConnectionTest {



  @Test
  public void testDbConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=&serverTimezone=UTC");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT group_name,group_id FROM group_list");
      Groups groups = new Groups();
      while (rs.next()){
        groups.add(new GroupDate().withId(rs.getInt("group_id")).withName(rs.getString("group_name")));
      }
      rs.close();
      st.close();
      conn.close();

      System.out.println(groups);
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
