package jpa.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "teachers")
@Table(name = "teachers")
@NamedQueries({@NamedQuery
        (name = "byName", query = "select t from teachers t where t.firstName = :firstName")})
public class Teacher {

    public enum Query {
        BY_NAME("byName", "firstName"),
        BY_LAST_NAME("byLastName", "lastName"),
        BY_AGE("byAge", "age");
        private String queryName;
        private String parameterName;

        Query(String queryName, String parameterName) {
            this.queryName = queryName;
            this.parameterName = parameterName;
        }

        public String getQueryName() {
            return queryName;
        }

        public String getParameterName() {
            return parameterName;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "teacher_id")
    private int teacherId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Transient
    private String fullName;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
