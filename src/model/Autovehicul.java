package model;

abstract public class Autovehicul {
    private float pret;
    private  String codSerial;
    private  int nrLocuri;
    private  float kilometrii;
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
}
