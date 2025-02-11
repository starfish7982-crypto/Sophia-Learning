import java.util.*;

public class GPA {

    // Return the corresponding grade based on the GPA value
    public static String getGrade(float gpa) {
        if (gpa >= 4.00) return "A+";
        if (gpa >= 3.67) return "A";
        if (gpa >= 3.33) return "A-";
        if (gpa >= 3.00) return "B+";
        if (gpa >= 2.67) return "B";
        if (gpa >= 2.33) return "B-";
        if (gpa >= 2.00) return "C+";
        if (gpa >= 1.67) return "C";
        if (gpa >= 1.33) return "C-";
        if (gpa >= 1.00) return "D+";
        if (gpa >= 0.67) return "D";
        if (gpa >= 0.00) return "D-";
        return "F";
    }

    // Check if the GPA input is valid
    public static float getValidGPA(Scanner scanner, String subject) {
        float gpa;
        while (true) {
            System.out.print(subject + ": ");
            gpa = scanner.nextFloat();
            if (gpa >= 0.00 && gpa <= 4.00) {
                break; // Valid GPA, exit the loop
            } else {
                System.out.println("Invalid GPA, please enter a number between 0.00 and 4.00.");
            }
        }
        return gpa;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String teacherName = "";
        String studentName;
        float mathGPA, englishGPA, PE_GPA;

        // Ask for the teacher's name
        System.out.print("Please enter the teacher's name: ");
        teacherName = scanner.nextLine();

        while (true) {
            System.out.print("Please enter the student's name: ");
            studentName = scanner.nextLine();

            System.out.println("Please enter the GPA scores for each subject:");

            // Use the getValidGPA method to ensure the GPA input is valid
            mathGPA = getValidGPA(scanner, "Math");
            englishGPA = getValidGPA(scanner, "English");
            PE_GPA = getValidGPA(scanner, "PE");

            // Create a GPARecord object
            GPARecord record = new GPARecord(studentName, teacherName, mathGPA, englishGPA, PE_GPA);

            // Output to file
            GPARecord.logToFile(record.toLogString());

            // Display the data
            System.out.println(record.toLogString());

            // Continue entering options
            System.out.print("\nWould you like to enter the next student's data? (y/n): ");
            scanner.nextLine();  // Clear the buffer
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }

        // Display the records
        List<String> records = GPARecord.readLogs();
        if (records.size() > 0) {
            System.out.println("\n---- Current all grade records ----");
        }

        System.out.println("Data has been saved, program terminated.");
        scanner.close();
    }
}
