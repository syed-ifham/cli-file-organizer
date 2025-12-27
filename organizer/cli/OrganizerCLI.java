package organizer.cli;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import organizer.core.*;
import organizer.util.*;
import organizer.scanner.*;
import organizer.service.*;

public class OrganizerCLI {

  public static void main(String[] args) {

    // validating arguments length
    if (args.length < 3) {
      System.out.println("Requires Minium 3 inputs");
      Helper.printUsage();
      return;
    }

    // validating "--by"
    if (!args[1].equals("--by")) {
      System.out.println("Input Error : Use --by");
      Helper.printUsage();
      return;
    }

    // CLI inputs
    String dirInput = args[0];
    String modeInput = args[2];

    Path rootDir;
    OrganizerMode mode = null;

    // validating mode argument
    try {
      mode = OrganizerMode.valueOf(modeInput.toUpperCase());
    } catch (IllegalArgumentException exp) {
      System.err.println("❌ Invalid mode: " + modeInput);
      Helper.printUsage();
      return;
    }

    // validating path
    try {
      rootDir = Paths.get(dirInput);
      PathValidator.validate(rootDir);

    } catch (IllegalArgumentException e) {
      System.err.println("❌ Invalid directory: " + e.getMessage());
      return;
    }

    // scan files
    List<Path> files = null;
    try {
      files = FileScanner.scan(rootDir);
    } catch (IOException e) {
      System.err.println("❌ Failed while scanning files: " + e.getMessage());
    }

    if (files.isEmpty()) {
      System.out.println("📁 Directory is empty. Nothing to organize.");
      return;
    }

    System.out.println("Copying ALL the files SAFELY.");

    // deciding mode
    OrganizerStrategy strategy = OrganizerStrategyFactory.getStrategy(mode);
    int movedCount = 0;
    for (Path file : files) {

      try {

        String folder = strategy.resolveTargetFolder(file); // decides folder Name
        FileMover.move(file, rootDir, folder); // moves into target folder
        movedCount++;
      } catch (IOException e) {
        System.err.println("⚠️ Skipped: " + file.getFileName());
      }

    }
    System.out.println("✅ Organization complete.");
    System.out.println("📦 Files processed: " + movedCount);
    System.out.println("📂 Mode used: " + mode);
  }
}
