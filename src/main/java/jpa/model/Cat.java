package jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "cat")
public class Cat {
    @Id
    @GeneratedValue
    @Column(name = "cat_id")
    private int id;

    private String name;

    @ManyToOne
    private CatOwner catOwner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CatOwner getCatOwner() {
        return catOwner;
    }

    public void setCatOwner(CatOwner catOwner) {
        this.catOwner = catOwner;
    }
}
