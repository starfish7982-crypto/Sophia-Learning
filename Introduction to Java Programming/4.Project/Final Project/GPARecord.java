import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GPARecord {
    private String studentName;
    private String teacherName;
    private float mathGPA;
    private float englishGPA;
    private float PE_GPA;
    private float averageGPA;

    // Constructor
    public GPARecord(String studentName, String teacherName, float mathGPA, float englishGPA, float PE_GPA) {
        this.studentName = studentName;
        this.teacherName = teacherName;
        this.mathGPA = mathGPA;
        this.englishGPA = englishGPA;
        this.PE_GPA = PE_GPA;
        this.averageGPA = (mathGPA + englishGPA + PE_GPA) / 3;
    }

    // Convert to formatted string
    public String toLogString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      return "\n---------- Grade Record ----------\n" +
               "Student: " + studentName + " Teacher: " + teacherName + "\n" +
               "Math GPA: " + mathGPA + "  Grade: " + GPA.getGrade(mathGPA) + "\n" +
               "English GPA: " + englishGPA + "  Grade: " + GPA.getGrade(englishGPA) + "\n" +
               "PE GPA: " + PE_GPA + "  Grade: " + GPA.getGrade(PE_GPA) + "\n" +
               "Average GPA: " + averageGPA + " Grade: " + GPA.getGrade(averageGPA) + "\n" +
               "Time: " + now.format(formatter) + "\n";

    }

    // Static method to log data to file
    public static void logToFile(String data) {
        try {
            String fileName = "grade_records.log.txt"; // Use a single file for all records
            FileWriter writer = new FileWriter(fileName, true); // Append to file
            writer.write(data + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Read all records from the log file
    public static List<String> readLogs() {
        List<String> records = new ArrayList<>();
        try {
            String fileName = "grade_records.log.txt"; // Use a fixed filename
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return records;
    }
}
