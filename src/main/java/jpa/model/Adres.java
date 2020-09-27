package jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "adresy")
public class Adres {
    @Id
    @GeneratedValue
    @Column(name = "adres_id")
    private int adresId;

    @Column(name = "miasto")
    private String miasto;
    @Column(name = "ulica")
    private String ulica;

    @OneToOne
    @JoinColumn(name = "osoba_id")
    private Osoba osoba;


    public int getAdresId() {
        return adresId;
    }

    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }
}
