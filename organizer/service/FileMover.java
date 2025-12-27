package organizer.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public final class FileMover {

  public static void move(Path sourceFile, Path rootDir, String targetFolder) throws IOException {

    Path targetDir = rootDir.resolve(targetFolder);

    // idempotent method
    Files.createDirectories(targetDir);
    Path targetFile = targetDir.resolve(sourceFile.getFileName());
    

  }

}
