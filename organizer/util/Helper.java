package organizer.util;

public class Helper {
  public static void printUsage() {
    System.out.println("""
        Usage:
          java OrganizerCLI <directory> --by <mode>

        Modes:
          extension   Organize files by file extension
          size        Organize files by size buckets

        Example:
          java OrganizerCLI C:\\Downloads --by extension
        """);
  }
}
