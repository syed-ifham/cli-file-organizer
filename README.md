📁 CLI File Organizer

A Java-based command-line utility that automatically organizes files in a directory by extension or size, using modern java.nio.file APIs.
Designed to be fast, safe, and fault-tolerant for real-world file systems.

🚀 What This App Does

Scans a directory recursively
Organizes files by:
File extension (.pdf, .jpg, .java, etc.)
File size ranges (small / medium / large)
Automatically creates destination folders
Safely moves files while handling:
Invalid paths
Permission-restricted files
Name collisions
Provides a summary report after execution

This tool is built as a CLI-first utility, focusing on clean design and reliability.

🧠 Why This Project Exists

Manually managing large directories is error-prone and time-consuming.
This project demonstrates how Java can be used to build practical system utilities using:

Modern File I/O (java.nio.file)
Clean separation of concerns
Robust exception handling
It’s intentionally simple, real-world, and interview-friendly.

🛠️ Tech Stack

Java (JDK 11+)
java.nio.file (Paths, Files, Directory Traversal)
Java Collections
Exception Handling
Git & GitHub

▶️ How to Use

1️⃣ Compile the Project
javac -d out src/main/java/com/yourname/organizer/cli/OrganizerCLI.java

2️⃣ Run the Tool
java -cp out com.yourname.organizer.cli.OrganizerCLI <directory> --by extension

or

java -cp out com.yourname.organizer.cli.OrganizerCLI <directory> --by size

📊 Example Output
Scanning directory: /Downloads

Files scanned      : 1042
Files organized    : 998
Skipped (permission): 32
Errors             : 12
Time taken         : 0.74 seconds

⚠️ Error Handling
Invalid paths are detected early
Permission errors do not stop execution
Problematic files are skipped and reported
The application never crashes mid-run

🧩 Current Status
🚧 In Progress

Planned enhancements:
Dry-run mode
Configurable size ranges
Logging support
Multithreaded file moves