package organizer.util;

import java.nio.file.*;

public class PathValidator {

  // stateless utility
  public static void validate(Path path) {

    if (!Files.exists(path)) {
      throw new IllegalArgumentException("❌ Path does not exist: " + path);
    }
    if (!Files.isDirectory(path)) {
      throw new IllegalArgumentException("❌ Path is not a directory:" + path);
    }
    if (!Files.isReadable(path)) {
      throw new IllegalArgumentException("❌ No read permission for directory:" + path);
    }
    if (!Files.isWritable(path)) {
      throw new IllegalArgumentException("❌ No write permission for directory:" + path);
    }

  }

}
