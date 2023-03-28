package lt.viko.eif.ivaliukas.legoprekyba.model;

import javax.persistence.*;

@Entity
@Table(name = "paskyra")
public class Paskyra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String vartotojoVardas;
    private String slaptazodis;

    public Paskyra(int id, String vartotojoVardas, String slaptazodis){
        this.id = id;
        this.vartotojoVardas = vartotojoVardas;
        this.slaptazodis = slaptazodis;
    }

    public Paskyra(String vartotojoVardas, String slaptazodis){
        this.vartotojoVardas = vartotojoVardas;
        this.slaptazodis = slaptazodis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVartotojoVardas() {
        return vartotojoVardas;
    }

    public void setVartotojoVardas(String vartotojoVardas) {
        this.vartotojoVardas = vartotojoVardas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }
    Paskyra(){}

    @Override
    public String toString() {
        return String.format("\tPaskyra : \n\t\t\t" +
                "VartotojoVardas = %s\n\t\t\t" +
                "Slaptazodis = %s\n\t\t",
                this.vartotojoVardas,
                this.slaptazodis);
    }
}
