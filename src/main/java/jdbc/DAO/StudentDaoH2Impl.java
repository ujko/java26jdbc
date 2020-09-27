package jdbc.DAO;

import jdbc.model.Student;

import java.util.List;

public class StudentDaoH2Impl implements StudentDao{
    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student getById(int studentId) {
        return null;
    }

    @Override
    public List<Student> getByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Student> getByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Student> getByAgeBetween(int from, int to) {
        return null;
    }

    @Override
    public Student createStudent(Student student) {
        return null;
    }

    @Override
    public Student modifyStudent(int idToModify, Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Student student) {

    }
}
