package jpa;

import jpa.model.CatOwner;
import jpa.model.Nauczyciel;
import jpa.model.Uczen;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("mySql");
        EntityManager em = factory.createEntityManager();

//        em.getTransaction().begin();
//        Uczen u1 = new Uczen();
//        u1.setName("Magda");
//        em.persist(u1);
//
//        Uczen u2 = new Uczen();
//        u2.setName("Adam");
//        em.persist(u2);
//
//        Nauczyciel n = new Nauczyciel();
//        n.setName("Krzysztof");

//        em.persist(n);
        Uczen u1 = em.find(Uczen.class, 1);
        Uczen u2 = em.find(Uczen.class, 2);
        Nauczyciel n = em.find(Nauczyciel.class, 3);
        em.close();
        System.out.println(u1.getName() + " " +
                u1.getNauczyciele().stream()
                        .map(Nauczyciel::getName)
                .collect(Collectors.joining(", ")));
        System.out.println("--------------------");

        System.out.println(u2.getName() + " " +
                u2.getNauczyciele().stream()
                        .map(Nauczyciel::getName)
                        .collect(Collectors.joining(", ")));
        System.out.println("--------------------");
        System.out.println(n.getName() + " " +
                n.getUczniowie().stream()
                        .map(Uczen::getName)
                        .collect(Collectors.joining(", ")));



//        Uczen u3 = em.find(Uczen.class, 6);
//
//        Nauczyciel n1 = em.find(Nauczyciel.class, 1);
//        Nauczyciel n2 = em.find(Nauczyciel.class, 2);
//        Nauczyciel n3 = em.find(Nauczyciel.class, 3);
//
//        n1.addUczen(u1);
//        n1.addUczen(u2);
//        n1.addUczen(u3);

//        em.getTransaction().commit();

    }
}
