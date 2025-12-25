package organizer.service;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;

public class SizeOrganizer implements OrganizerStrategy {

  @Override
  public String resolveTargetFolder(Path file) {

    try {
      long size = Files.size(file);
      // 100KB
      if (size < 1_000_000)
        return "SMALL";
      // 1MB
      if (size < 10_000_000)
        return "MEDIUM";
      // greater than 1 MB
      return "LARGE";
    } catch (IOException e) {
      return "UNKNOWN_SIZE";
    }

  }

}
