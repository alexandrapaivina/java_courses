package ru.stqa.pft.adressbook_second.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.adressbook.model.Contact;
import ru.stqa.pft.adressbook_second.model.ContactDate;
import ru.stqa.pft.adressbook_second.model.Contacts;
import ru.stqa.pft.adressbook_second.model.GroupDate;
import ru.stqa.pft.adressbook_second.model.Groups;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }

  public Groups groups(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupDate> result = session.createQuery( "from GroupDate" ).list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactDate> result = session.createQuery( "from ContactDate where deprecated = null" ).list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }

  public void addGroup(GroupDate group){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(group);
    session.getTransaction().commit();
    session.close();
  }

  public void addContact(ContactDate contact){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(contact);
    session.getTransaction().commit();
    session.close();
  }

}
