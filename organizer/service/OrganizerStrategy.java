package organizer.service;

import java.nio.file.Path;

public interface OrganizerStrategy {
  // resolve the target directory name for given file
  public String resolveTargetFolder(Path file);

}
