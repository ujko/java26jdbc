package jpa;

import jpa.model.Account;
import jpa.model.AccountId;
import jpa.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.setFirstName("Krzysztof");
        t.setLastName("Nowak");
        t.setBirthDate(LocalDate.of(1984, 12, 23));

//        Account a = new Account();
//        a.setName("1");
//        a.setNumber("dfhakdhjlfa");
//        a.setType("3");


        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("mySql");
        EntityManager em = factory.createEntityManager();
//        Teacher teacher = em.find(Teacher.class, 1);
//        System.out.println(teacher);



        em.getTransaction().begin();
//        Teacher teacher = em.find(Teacher.class, 1);
//        teacher.setFirstName("Jarek");
        em.persist(t);
//
//        System.out.println(t);
        em.getTransaction().commit();

//        Account account = em.find(Account.class, new AccountId("3", "1"));
//        System.out.println(account);
        em.close();
    }
}
