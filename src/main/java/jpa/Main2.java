package jpa;

import jpa.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main2 {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("mySql");
        EntityManager em = factory.createEntityManager();


        TypedQuery<Teacher> query =
                em.createNamedQuery(Teacher.Query.BY_NAME.getQueryName(), Teacher.class);
        query.setParameter(Teacher.Query.BY_NAME.getParameterName(), "Anna");
        query.getResultList().forEach(System.out::println);


        em.close();
    }
}
