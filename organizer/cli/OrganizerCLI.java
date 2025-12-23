//keep this file as short as possible
package organizer.cli;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import organizer.util.*;
import organizer.core.*;
import organizer.scanner.*;

public class OrganizerCLI {

  // stateless helper method
  private static void printUsage() {
    System.out.println("Use command : java OrganizerCLI <directory> --by <mode>");
  }

  public static void main(String[] args) {

    // validating arguments length
    if (args.length != 3) {
      OrganizerCLI.printUsage();
      return;
    }

    if (!args[1].equals("--by")) {
      System.out.println("Input Error : Use --by");
      OrganizerCLI.printUsage();
      return;
    }

    // CLI inputs
    String dir = args[0];
    OrganizerMode mode = null;

    // validating mode arguments
    try {
      mode = OrganizerMode.valueOf(args[2].toUpperCase());
    } catch (IllegalArgumentException exp) {
      System.err.println("Available Options : [extension,size]");
      printUsage();
      return;
    }

    Path path = Paths.get(dir);

    // validating path
    try {
      PathValidator.validate(path);

    } catch (IllegalArgumentException exp) {
      System.err.println(exp.getMessage());
      return; // return here only
    }

    System.out.println("Starting organizer...");
    System.out.println("Directory: " + dir);
    System.out.println("Mode: " + mode);
    System.out.println("isReadable: " + Files.isReadable(path));
    System.out.println("isWritable: " + Files.isWritable(path));

    // scanner filters readable files only
    try {
      List<Path> files = FileScanner.scan(path);
      if (files.isEmpty()) {

        System.out.println("no files found!");
        System.out.println("is empty : " + files.isEmpty());
        return;
      }

      System.out.println("Files found: " + files.size() );// size in kb
      // files.forEach(System.out::println); // testing purpose

    } catch (IOException e) {
      System.err.println("Failed to scan directory");
    }

    switch (mode) {
      case EXTENSION:
        break;
      case SIZE:
        break;
      default:
        break;
    }

  }

}
