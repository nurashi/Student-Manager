
import java.util.*;
import models.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IStorage database = new Database();
        StudentManager studentManager =new StudentManager(database);

        List<Student> students = studentManager.loadStudent();

        while(true) {
            System.out.println("1) Add Student to Base");
            System.out.println("2) Delete Student from Base");
            System.out.println("3) Print students");
            System.out.println("4) Save all and exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter ID of a student - ");
                int id = scanner.nextInt();
                System.out.println("Enter name of a student - ");
                String name = scanner.next();
                System.out.println("Enter age of a student - ");
                int age = scanner.nextInt();
                System.out.println("Enter phone of a student - ");
                String phone = scanner.next();
                Student student = new Student(id, name, age, phone);
                studentManager.addStudent(students, student);
            }
            if (choice == 2) {
                System.out.println("Enter ID of a student for !DELETING! from base - ");
                int id = scanner.nextInt();
                studentManager.deleteStudent(students, id);
            }
            if (choice == 3) {
                System.out.println("ALl students list\n");
                studentManager.printStudents(students);
            }
            if(choice == 4) {
                System.out.println("Exiting...");
                studentManager.saveStudent(students);
                break;
            }
        }
    }
}