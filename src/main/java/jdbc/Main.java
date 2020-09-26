package jdbc;

import jdbc.DAO.StudentDao;
import jdbc.DAO.StudentDaoImpl;
import jdbc.model.Student;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();
        System.out.println(dao.createStudent(new Student("Agata", null,
                LocalDate.of(1982, 03, 11))));
        dao.getAll().forEach(System.out::println);
//        System.out.println(dao.getById(2));
//        System.out.println(dao.getByFirstName("sia"));



    }

}
