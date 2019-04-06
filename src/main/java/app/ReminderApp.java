package app;

import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;

public class ReminderApp {

  private static final Gson gson = new Gson();

  public static void main(String[] args) throws Exception {
    Path data = Path.of("reminders.txt");
    switch (args[0]) {
      case "add":
        addReminder(data, args);
        break;
      case "list":
        listReminders(data);
        break;
    }
  }

  private static void listReminders(Path data) throws Exception {
    LocalDate now = LocalDate.now();

    Reminder[] items = gson.fromJson(Files.readString(data), Reminder[].class);
    for (Reminder item : items) {
      if (item.getDeadline().isAfter(now)) {
        System.out.println(item);
      }
    }
  }

  private static void addReminder(Path data, String[] args) throws Exception {
    Reminder toAdd = new Reminder(LocalDate.parse(args[1]), args[2]);

    Reminder[] items = gson.fromJson(Files.readString(data), Reminder[].class);
    items = Arrays.copyOf(items, items.length + 1);
    items[items.length - 1] = toAdd;
    Files.writeString(data, gson.toJson(items));
  }
}
