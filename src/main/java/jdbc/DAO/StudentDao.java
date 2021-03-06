package jdbc.DAO;

import jdbc.model.Student;

import java.util.List;

public interface StudentDao {
    int a = 5;

    List<Student> getAll();
    Student getById(int studentId);
    List<Student> getByFirstName(String firstName);
    List<Student> getByLastName(String lastName);
    List<Student> getByAgeBetween(int from, int to);
    Student createStudent(Student student);
    Student modifyStudent(int idToModify, Student student);
    void deleteStudent(Student student);
}
