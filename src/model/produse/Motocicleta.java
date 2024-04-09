package model.produse;

public class Motocicleta extends Autovehicul{
    private int hp;
    @Override
    public String informatiiPoluare() {
        return "Motocicleta polueaza " +hp*100 +" kilograme de carbon per kilometru";
    }

    public Motocicleta(float pret, String codSerial, int nrLocuri, float kilometrii, int hp) {
        super(pret, codSerial, nrLocuri, kilometrii);
        this.hp = hp;
    }

    public Motocicleta(float pret, String codSerial, int nrLocuri, int hp) {
        super(pret, codSerial, nrLocuri);
        this.hp = hp;
    }

    public Motocicleta(String codSerial, float pret, int hp) {
        super(codSerial, pret);
        this.hp = hp;
    }

    public Motocicleta(String codSerial, int hp) {
        super(codSerial);
        this.hp = hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "hp=" + hp +
                "cod= "+getCodSerial()
                +"pret= "+getPret()
                +" cumparator = " +getCumparator()
                +" vanzator = "+getVanzatorul();
    }
}
