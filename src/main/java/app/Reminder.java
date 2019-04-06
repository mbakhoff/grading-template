package app;

import java.time.LocalDate;

public class Reminder {

  private LocalDate deadline;
  private String description;

  public Reminder() {
  }

  public Reminder(LocalDate deadline, String description) {
    this.deadline = deadline;
    this.description = description;
  }

  public LocalDate getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Reminder{" +
        "deadline=" + deadline +
        ", description='" + description + '\'' +
        '}';
  }
}
