package Java_practical;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main 
{
    private static final String FILENAME = "student_records.ser";
    private static final Logger logger = Logger.getLogger(StudentManager.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        StudentManager<Student> studentManager = new StudentManager<Student>();
        loadFromFile(studentManager);

        while (true) 
        {
            System.out.println("Enter a command (add, remove, search, report, quit):");
            String command = scanner.nextLine().trim();
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
                case "quit":
                    saveToFile(studentManager);
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }
}



