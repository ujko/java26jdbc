package jpa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "uczniowie")
public class Uczen {
    @Id
    @Column(name = "id_ucznia")
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Nauczyciel> nauczyciele = new HashSet<>();

    public void addNauczyciel(Nauczyciel nauczyciel) {
        nauczyciele.add(nauczyciel);
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

    public Set<Nauczyciel> getNauczyciele() {
        return nauczyciele;
    }

    public void setNauczyciele(Set<Nauczyciel> nauczyciele) {
        this.nauczyciele = nauczyciele;
    }
}
