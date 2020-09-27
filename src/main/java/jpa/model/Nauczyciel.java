package jpa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nauczyciele")
public class Nauczyciel {

    @Id
    @Column(name = "id_nauczyciela")
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(mappedBy = "nauczyciele", fetch = FetchType.EAGER)
    private Set<Uczen> uczniowie = new HashSet<>();

    public void addUczen(Uczen uczen) {
        uczniowie.add(uczen);
    }

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

    public Set<Uczen> getUczniowie() {
        return uczniowie;
    }

    public void setUczniowie(Set<Uczen> uczniowie) {
        this.uczniowie = uczniowie;
    }
}
