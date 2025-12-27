package organizer.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

public final class FileMover {

  public static void move(Path sourceFile, Path rootDir, String targetFolder) throws IOException {

    // creates path : root/targetFolder
    Path targetDir = rootDir.resolve(targetFolder);

    // ensures existence
    Files.createDirectories(targetDir);

    // choosing a safe destination
    Path targetFile = targetDir.resolve(sourceFile.getFileName());
    Path finalTarget = resolveUniqueTarget(targetFile); // handle collision

    // using atomic move - Simple, do or nothing
    // Files.move(sourceFile, finalTarget, StandardCopyOption.ATOMIC_MOVE);
    Files.copy(sourceFile, finalTarget);

  }

  private static Path resolveUniqueTarget(Path targetFile) {

    if (!Files.exists(targetFile)) {
      return targetFile;
    }

    String name = targetFile.getFileName().toString();
    String base, ext;

    int dot = name.lastIndexOf('.');
    if (dot == -1) {
      base = name;
      ext = "";
    } else {
      base = name.substring(0, dot);
      ext = name.substring(dot);
    }

    int count = 1;
    Path parent = targetFile.getParent();

    Path candiate = parent.resolve(name);
    do {
      candiate = parent.resolve(base + "(" + count + ")" + ext);
      count++;
    } while (Files.exists(candiate));
    return candiate;
  }
}
