package lt.viko.eif.ivaliukas.legoprekyba.model;

import jakarta.xml.bind.annotation.*;

import javax.persistence.*;
import java.util.List;

@XmlRootElement (name = "Pardavejas")
@XmlType(propOrder = {"id","vardas","pavarde","telNumeris","paskyra","lego"})
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "pardavejas")
public class Pardavejas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String vardas;
    private String pavarde;
    private String telNumeris;
    @OneToOne(targetEntity = Paskyra.class,cascade = CascadeType.ALL)
    private Paskyra paskyra;
    @XmlElementWrapper(name = "lego")
    @XmlElement(name = "legoKonstruktorius")
    @OneToMany(targetEntity = LegoKonstruktorius.class,cascade = CascadeType.ALL)
    private List<LegoKonstruktorius> lego;

    public Pardavejas(int id, String vardas, String pavarde, String telNumeris, Paskyra paskyra, List<LegoKonstruktorius> lego){
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.telNumeris = telNumeris;
        this.paskyra = paskyra;
        this.lego = lego;
    }

    public Pardavejas(String vardas, String pavarde, String telNumeris, Paskyra paskyra, List<LegoKonstruktorius> lego){
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.telNumeris = telNumeris;
        this.paskyra = paskyra;
        this.lego = lego;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getTelNumeris() {
        return telNumeris;
    }

    public void setTelNumeris(String telNumeris) {
        this.telNumeris = telNumeris;
    }

    public Paskyra getPaskyra() {
        return paskyra;
    }

    public void setPaskyra(Paskyra paskyra) {
        this.paskyra = paskyra;
    }

    public List<LegoKonstruktorius> getLego() {
        return lego;
    }

    public void setLego(List<LegoKonstruktorius> lego) {
        this.lego = lego;
    }
    Pardavejas(){}

    @Override
    public String toString() {
        return String.format("Pardavejas:\n\t" +
                        "id= %s\n\t" +
                        "Vardas= %s\n\t" +
                        "Pavarde= %s\n\t" +
                        "Paskyra: \n\t%s\n"+
                        "\t\tLego:\n\t\t%s",
                        this.id,
                        this.vardas,
                        this.pavarde,
                        this.paskyra,
                        constructSubjectString());
    }

    private String constructSubjectString(){
        String result = "";
        for (LegoKonstruktorius legoKonstruktorius : this.lego){
            result += legoKonstruktorius.toString();
        }
        return  result;
    }
}
