package models;
import java.util.List;
public interface IStorage {
    void save(List<Student> students);
    List<Student> load();
}
