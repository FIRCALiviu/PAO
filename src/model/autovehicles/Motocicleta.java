package model.autovehicles;

public class Motocicleta extends Autovehicul{
    private int horsepower;
    @Override
    public String informatiiPoluare() {
        return "Motocicleta polueaza " + horsepower *100 +" kilograme de carbon per kilometru";
    }

    public Motocicleta(float pret, String codSerial, int nrLocuri, float kilometrii, int horsepower) {
        super(pret, codSerial, nrLocuri, kilometrii);
        this.horsepower = horsepower;
    }

    public Motocicleta(float pret, String codSerial, int nrLocuri, int horsepower) {
        super(pret, codSerial, nrLocuri);
        this.horsepower = horsepower;
    }

    public Motocicleta(String codSerial, float pret, int horsepower) {
        super(codSerial, pret);
        this.horsepower = horsepower;
    }

    public Motocicleta(String codSerial, int hp) {
        super(codSerial);
        this.horsepower = hp;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "horsepower=" + horsepower +
                "cod= "+getCodSerial()
                +"pret= "+getPret()
                +" cumparator = " +getCumparator()
                +" vanzator = "+getVanzatorul();
    }
}
