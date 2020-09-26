package DAO;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final static String DB_CON =
            "jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC";
    private Connection connection;

    private void createConnection() {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            connection = DriverManager.getConnection(DB_CON, "root", "example");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            System.out.println("not opened");
        }
    }

    @Override
    public List<Student> getAll() {
        String query = "select * from student";
        List<Student> students = new ArrayList<>();
        createConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Student s = new Student();
                fillStudent(s, rs);
                students.add(s);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
        return students;
    }

    private void fillStudent(Student st, ResultSet rs) throws SQLException {
        st.setId(rs.getInt("id"));
        st.setFirstName(rs.getString("first_name"));
        st.setLastName(rs.getString("last_name"));
        st.setBirthDate(rs.getDate("birth_date").toLocalDate());
    }

    @Override
    public Student getById(int studentId) {
//        String query = "select * from student where id = " + studentId;
        String query = String.format("select * from student where id = %d", studentId);
        Student student = new Student();
        createConnection();
        try (Statement s = connection.createStatement()) {
            ResultSet rs = s.executeQuery(query);
            if (rs.next()) {
                fillStudent(student, rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        closeConnection();
        return student;
    }

    @Override
    public List<Student> getByFirstName(String firstName) {
//        String query = "select * from student where id = '" + firstName + "'";
        String query = "select * from student where lower(first_name) = ?";
        List<Student> students = new ArrayList<>();
        createConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student s = new Student();
                fillStudent(s, resultSet);
                students.add(s);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
        return students;
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
        String query = "insert into student values(?,?,?,?)";
        int max = getNewId();
        createConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, max);
            ps.setString(2, student.getFirstName() == null ? "noname" : student.getFirstName());
            ps.setString(3, student.getLastName() == null ? "noname" : student.getLastName());
            ps.setDate(4, Date.valueOf(student.getBirthDate()));
            boolean execute = ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
        return getById(max);
    }

    private int getNewId() {
        return getAll()
                .stream()
                .map(Student::getId)
                .mapToInt(x -> x)
                .max()
                .orElse(0) + 1;
    }

    @Override
    public Student modifyStudent(int idToModify, Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Student student) {

    }
}
