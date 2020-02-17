package at.htlstp.tod.aufgabensammlung.mvc.bsp2.model;// package at.reio.as.spring.schueler.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="schueler")
public class Schueler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sch_id")
    private Integer id;

    @Column(name="sch_kn")
    private Integer kn;

    @Column(name="sch_klasse")
    private String klasse;

    @NotBlank(message = "Vorname darf nicht leer sein!")
    @Column(name="sch_vorname")
    private String vorname;

    @NotBlank(message = "Nachname darf nicht leer sein!")
    @Column(name="sch_nachname")
    private String nachname;

//    @Pattern(regexp = "[M|W]")
    @Column(name="sch_sex")
    private char geschlecht;

    public Schueler() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKn() {
        return kn;
    }

    public void setKn(Integer kn) {
        this.kn = kn;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public char getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(char geschlecht) {
        this.geschlecht = geschlecht;
    }
}
