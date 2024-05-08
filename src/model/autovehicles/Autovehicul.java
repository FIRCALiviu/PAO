package model.autovehicles;

import java.util.Objects;

abstract public class Autovehicul {
    private float pret;
    private  String codSerial;
    private  int nrLocuri;
    private  float kilometrii;
    private String vanzatorul;
    private String cumparator;
    public abstract String informatiiPoluare();





    public Autovehicul(float pret, String codSerial, int nrLocuri, float kilometrii) {
        this.pret = pret;
        this.codSerial = codSerial;
        this.nrLocuri = nrLocuri;
        this.kilometrii = kilometrii;
    }

    public Autovehicul(float pret, String codSerial, int nrLocuri) {
        this.pret = pret;
        this.codSerial = codSerial;
        this.nrLocuri = nrLocuri;
    }

    public Autovehicul(String codSerial,float pret) {
        this.codSerial = codSerial;
        this.pret = pret;
    }

    public Autovehicul(String codSerial) {
        this.codSerial = codSerial;
    }

    public float getPret() {
        return pret;
    }

    public String getCodSerial() {
        return codSerial;
    }
    public String getCumparator() {
        return cumparator;
    }

    public void setCumparator(String cumparator) {
        this.cumparator = cumparator;
    }

    public void setVanzatorul(String vanzatorul) {
        this.vanzatorul = vanzatorul;
    }

    public String getVanzatorul() {
        return vanzatorul;
    }
    public int getNrLocuri() {
        return nrLocuri;
    }

    @Override
    public String toString() {
        return "Autovehicul{" +
                "pret=" + pret +
                ", codSerial='" + codSerial + '\'' +
                ", nrLocuri=" + nrLocuri +
                '}';
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setCodSerial(String codSerial) {
        this.codSerial = codSerial;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public float getKilometrii() {
        return kilometrii;
    }

    public void setKilometrii(float kilometrii) {
        this.kilometrii = kilometrii;
    }

    @Override
    public int hashCode() {
        return codSerial.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null ) return false;
        if (obj instanceof  Autovehicul) return Objects.equals(codSerial,((Autovehicul) obj).codSerial);
        return false;
    }
}
