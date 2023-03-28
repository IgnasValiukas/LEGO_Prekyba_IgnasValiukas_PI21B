package lt.viko.eif.ivaliukas.legoprekyba.model;

import javax.persistence.*;

@Entity
@Table(name = "legoKonstruktorius")
public class LegoKonstruktorius {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String pavadinimas;
    private String legoNr;

    public LegoKonstruktorius(int id, String pavadinimas, String legoNr){
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.legoNr = legoNr;
    }

    public LegoKonstruktorius(String pavadinimas, String legoNr){
        this.pavadinimas = pavadinimas;
        this.legoNr = legoNr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getLegoNr() {
        return legoNr;
    }

    public void setLegoNr(String legoNr) {
        this.legoNr = legoNr;
    }
    LegoKonstruktorius(){}

    @Override
    public String toString() {
        return String.format("\tLego : \n\t\t\t" +
                "\tPavadinimas = %s\n\t\t\t" +
                "\tLegoNr = %s\n\t\t",
                this.pavadinimas,
                this.legoNr);
    }
}
