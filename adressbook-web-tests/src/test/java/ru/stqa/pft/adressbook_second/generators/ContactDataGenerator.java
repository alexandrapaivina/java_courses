package ru.stqa.pft.adressbook_second.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.adressbook_second.model.ContactDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Date format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactDate> contacts = generateContacts(count);
    if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsJson(List<ContactDate> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private List<ContactDate> generateContacts(int count) {
    List<ContactDate> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactDate().withFirstname(String.format("first name %s", i)).withMiddlename(String.format("middle name %s", i))
              .withLastname(String.format("last name %s", i)).withEmail(String.format("test%s@test.ru", i)).withMobilephone(String.format("8900888776%s", i)));
    }
    return contacts;
  }
}
