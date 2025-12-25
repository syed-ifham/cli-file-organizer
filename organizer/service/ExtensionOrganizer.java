package organizer.service;

import java.nio.file.Path;

public class ExtensionOrganizer implements OrganizerStrategy {
  @Override
  public String resolveTargetFolder(Path file) {

    String name = file.getFileName().toString();
    int dot = name.lastIndexOf(".");
    if (dot == -1) {
      return "No_EXTENSION";
    }

    return name.substring(dot + 1).toUpperCase();
  }
}
