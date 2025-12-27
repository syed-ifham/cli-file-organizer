package organizer.service;

import java.nio.file.Path;
import java.util.List;

public class ExtensionOrganizer implements OrganizerStrategy {

  @Override
  public String resolveTargetFolder(Path file) {

    String name = file.getFileName().toString();
    int dot = name.lastIndexOf(".");
    return (dot == -1) ? "no-extension" : name.substring(dot + 1);

  }
}
