package jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "osoby")
public class Osoba {
    @Id
    @GeneratedValue
    @Column(name = "osoba_id")
    private int id;
    @Column(name = "nazwisko")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "os_id")
    private Adres adres;

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

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
