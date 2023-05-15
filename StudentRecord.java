package Java_practical;
import java.util.*;
import java.util.logging.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class StudentRecord
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILENAME = "students.ser";
    private static final Logger logger = Logger.getLogger("StudentRecordsApp");

    public static void main(String[] args) 
    {
        StudentManager<Student> studentManager = new StudentManager<Student>();

        while (true) 
        {
            System.out.println("Enter command (add, remove, search, report, exit):");
            String command = scanner.nextLine().trim().toLowerCase();
            switch (command) 
            {
                case "add":
                    addStudent(studentManager);
                    break;
                case "remove":
                    removeStudent(studentManager);
                    break;
                case "search":
                    searchStudents(studentManager);
                    break;
                case "report":
                    printReport(studentManager.getAll());
                    break;
                case "exit":
                    saveToFile(studentManager);
                    System.exit(0);
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    private static void addStudent(StudentManager<Student> studentManager) {
        System.out.println("Enter name:");
        String name = scanner.nextLine().trim();
        System.out.println("Enter student ID:");
        String id = scanner.nextLine().trim();
        System.out.println("Enter email:");
        String email = scanner.nextLine().trim();
        LocalDate dob = null;
        while (dob == null) 
        {
            System.out.println("Enter date of birth (yyyy-mm-dd):");
            String dobStr = scanner.nextLine().trim();
            try 
            {
                dob = LocalDate.parse(dobStr);
            } 
            catch (DateTimeParseException error) 
            {
                System.out.println("Invalid date format.");
            }
        }
        Student student = new Student(name, id, email, dob);
        studentManager.add(student);
    }

    private static void removeStudent(StudentManager<Student> studentManager) 
    {
        System.out.println("Enter student ID:");
        String id = scanner.nextLine().trim();
        List<Student> studentsToRemove = new ArrayList<Student>();
        for (Student student : studentManager.getAll()) 
        {
            if (student.getId().equals(id)) 
            {
                studentsToRemove.add(student);
            }
        }
        for (Student student : studentsToRemove) 
        {
            studentManager.remove(student);
        }
    }

    private static void searchStudents(StudentManager<Student> studentManager) 
    {
        System.out.println("Enter search keyword:");
        String keyword = scanner.nextLine().trim();
        List<Student> result = studentManager.search(keyword);
        if (result.isEmpty()) 
        {
            System.out.println("No matching students found.");
        } 
        else 
        {
            printReport(result);
        }
    }

    private static void printReport(List<Student> students) 
    {
        System.out.println("Student report:");
        for (Student student : students) 
        {
            System.out.println(student.toString());
        }
    }

    private static void saveToFile(StudentManager<Student> studentManager) 
    {
        try 
        {
            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(studentManager.getAll());
            objectOut.close();
            fileOut.close();
            logger.log(Level.INFO, "Saved student records to file.");
        } 
        catch (IOException e) 
        {
            logger.log(Level.WARNING, "Failed to save student records to file.", e);
        }
    }
}

