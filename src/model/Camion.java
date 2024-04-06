package model;

public class Camion extends  Masina{

    private  double volumMarfa;
    private float lungime,latime,inaltime;

    @Override
    public String informatiiPoluare() {
        return "Camionul consuma"+getPoluare();
    }


    public Camion(String codSerial, float pret, int putereMotor, String poluare, double volumMarfa, float lungime, float latime, float inaltime) {
        super(codSerial, pret, putereMotor, poluare);
        this.volumMarfa = volumMarfa;
        this.lungime = lungime;
        this.latime = latime;
        this.inaltime = inaltime;
    }

    public Camion(float pret, String codSerial, int nrLocuri, float kilometrii, int putereMotor, String culoare, String poluare, double volumMarfa, float lungime, float latime, float inaltime) {
        super(pret, codSerial, nrLocuri, kilometrii, putereMotor, culoare, poluare);
        this.volumMarfa = volumMarfa;
        this.lungime = lungime;
        this.latime = latime;
        this.inaltime = inaltime;
    }

    public void setVolumMarfa(double volumMarfa) {
        this.volumMarfa = volumMarfa;
    }

    public void setLungime(float lungime) {
        this.lungime = lungime;
    }

    public void setLatime(float latime) {
        this.latime = latime;
    }

    public void setInaltime(float inaltime) {
        this.inaltime = inaltime;
    }

    public double getVolumMarfa() {
        return volumMarfa;
    }

    public float getLungime() {
        return lungime;
    }

    public float getLatime() {
        return latime;
    }

    public float getInaltime() {
        return inaltime;
    }
}
