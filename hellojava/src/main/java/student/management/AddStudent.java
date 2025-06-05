package student.management;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AddStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        boolean continueInput = true;

        while (continueInput) {
            System.out.print("Enter student ID: ");
            String scannedStudentId = scanner.nextLine();

            System.out.print("Enter student name: ");
            String scannedName = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String scannedPhoneNumber = scanner.nextLine();

            System.out.print("Enter email: ");
            String scannedEmail = scanner.nextLine();

            Student student = new Student(scannedStudentId, scannedName, scannedPhoneNumber, scannedEmail);
            studentList.add(student);

            System.out.print("\nStudent created successfully:");
            System.out.print(student);

            System.out.print("\nAd another student? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("no")){
                continueInput = false;
            }
            System.out.println();
        }
        System.out.println("All students created:");
        DisplayStudent(studentList);
        scanner.close();
    }

    public static void DisplayStudent (List<Student> students)
    {
        for (Student student: students){
            System.out.println(student);
        }
    }
}






