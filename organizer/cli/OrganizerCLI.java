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
    String mode = args[2];

    // validating arguments mode
    if (!mode.equals(OrganizerMode.extension) && !mode.equals("size")) {
      System.out.println("Available Mode : extension or size");
      printUsage();
      return;
    }

    Path path = Paths.get(dir);
    // validates path
    try {
      PathValidator.validate(path);

    } catch (IllegalArgumentException exp) {
      System.out.println("❌ Arguments is/are wrong");
      System.out.println(exp.getMessage());
      return; // return here only 
    }

    System.out.println("Starting organizer...");

    System.out.println("✔ Directory: " + dir);
    System.out.println("✔ Mode: " + mode);

  }

}
