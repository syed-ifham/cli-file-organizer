package organizer.scanner;

import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.IOException;

public final class FileScanner {

  public static List<Path> scan(Path root) throws IOException {
    try (Stream<Path> paths = Files.walk(root)) {

      return paths.filter(Files::isRegularFile)
          .collect(Collectors.toList());

    }
  }

}
