package jpa;

import jpa.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main3 {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("mySql");
        EntityManager em = factory.createEntityManager();
//        Cat cat = em.find(Cat.class, 2);
//        System.out.println(cat.getName());
        CatOwner co = em.find(CatOwner.class, 1);
        System.out.println(co.getOwnerName());

        System.out.println(co.getCats().get(0).getName());
        em.close();
//        System.out.println(cat.getCatOwner().getOwnerName());
    }


    //        Salon s = new Salon();
//        s.setName("Opel salon");
//        Car car = new Car();
//        car.setSalon(s);
//        car.setType("BMW");
//        em.getTransaction().begin();
//        em.persist(car);
//        em.getTransaction().commit();
//    Trainee t = new Trainee();
//        t.setName("Pawel");
//        t.setPhoneNumber("999999999999");

//    Adres a = new Adres();
//        a.setMiasto("Lodz");
//        a.setUlica("Piotrkowska");
//    Osoba o = new Osoba();
//        a.setOsoba(o);
//        o.setName("Krzysztof");
//        o.setAdres(a);
//        em.getTransaction().begin();
//        em.persist(a);
//        em.persist(o);
//        em.getTransaction().commit();

//    Osoba osoba = em.find(Osoba.class, 2);
//        System.out.println(osoba.getName());
//
//        System.out.println(osoba.getAdres().getMiasto());
//        em.close();
//        System.out.println(osoba.getName() + " " + osoba.getAdres().getMiasto());

//    Cat c1 = new Cat();
//        c1.setName("Mruczek");
//    Cat c2 = new Cat();
//        c2.setName("Klopsik");
//    CatOwner co = new CatOwner();
//        c1.setCatOwner(co);
//        c2.setCatOwner(co);
//        co.setOwnerName("Adam");
//        co.addCat(c1);
//        co.addCat(c2);
//        em.getTransaction().begin();
//        em.persist(co);
//        em.persist(c1);
//        em.persist(c2);
//        em.getTransaction().commit();


}
