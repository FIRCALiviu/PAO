package model.produse;

import model.produse.Autovehicul;

public class Masina extends Autovehicul {
    private  int putereMotor;


    private  String poluare;
    private  String culoare;
    @Override
    public String informatiiPoluare() {
        return "Masina consuma "+poluare;
    }

    public Masina(String codSerial, float pret, int putereMotor, String poluare) {
        super(codSerial, pret);
        this.putereMotor = putereMotor;
        this.poluare = poluare;
    }

    public Masina(float pret, String codSerial, int nrLocuri, float kilometrii, int putereMotor, String poluare) {
        super(pret, codSerial, nrLocuri, kilometrii);
        this.putereMotor = putereMotor;
        this.poluare = poluare;
    }

    public Masina(float pret, String codSerial, int nrLocuri, float kilometrii, int putereMotor, String culoare, String poluare) {
        super(pret, codSerial, nrLocuri, kilometrii);
        this.putereMotor = putereMotor;
        this.culoare = culoare;
        this.poluare = poluare;
    }

    public Masina(float pret, String codSerial, int nrLocuri, int putereMotor, String culoare, String poluare) {
        super(pret, codSerial, nrLocuri);
        this.putereMotor = putereMotor;
        this.culoare = culoare;
        this.poluare = poluare;
    }

    public Masina(String codSerial, int putereMotor, String culoare, String poluare) {
        super(codSerial);
        this.putereMotor = putereMotor;
        this.culoare = culoare;
        this.poluare = poluare;
    }

    public void setPutereMotor(int putereMotor) {
        this.putereMotor = putereMotor;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public void setPoluare(String poluare) {
        this.poluare = poluare;
    }

    public int getPutereMotor() {
        return putereMotor;
    }

    public String getCuloare() {
        return culoare;
    }

    public String getPoluare() {
        return poluare;
    }

    @Override
    public String toString() {
        return "Masina are codul serial "+getCodSerial()+" cu culoare "+ culoare+"are o putere de motor "+putereMotor+" si costa "+getPret()+ " cu cumparatorul "+getCumparator()+ " si vanzatorul "+getVanzatorul();
    }
}
