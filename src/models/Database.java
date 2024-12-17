package models;
import java.sql.*;
import java.util.*;
import java.io.*;
public class Database implements IStorage {
    private static final String TEXT = "TEXT.txt";

    public void save(List<Student> students) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(TEXT))){
            for(Student student : students){
                writer.write(student.getId() + " " + student.getName() + " " + student.getAge()+ " " + student.getPhone());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> load() {
        List<Student> students = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(TEXT))){
            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                String name = scanner.next();
                int age = scanner.nextInt();
                String phone = scanner.next();
                students.add(new Student(id, name, age, phone));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
