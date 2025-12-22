//keep this file as short as possible
package organizer.cli;

import java.nio.file.*;
import organizer.util.*;
import organizer.core.*;

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
      System.out.println("Available Options : [extension,size]");
      printUsage();
      return;
    }

    Path path = Paths.get(dir);

    // validating path
    try {
      PathValidator.validate(path);

    } catch (IllegalArgumentException exp) {
      System.out.println(exp.getMessage());
      return; // return here only
    }

    System.out.println("Starting organizer...");
    System.out.println("Directory: " + dir);
    System.out.println("Mode: " + mode);

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
