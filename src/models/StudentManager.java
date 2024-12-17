package models;
import java.util.*;
public class StudentManager {
    private IStorage storage;
    public StudentManager(IStorage storage) {
        this.storage = storage;
    }

    public void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public void deleteStudent(List<Student> students, int id){
        students.removeIf(student -> student.getId() == id);
    }

    public void printStudents(List<Student> students){
        for(Student student : students) {
            System.out.println(student);
        }
    }

    public void saveStudent(List<Student> students) {
        storage.save(students);
    }

    public List<Student> loadStudent() {
        return storage.load();
    }
}

