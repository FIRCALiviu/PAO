package model.humanresources;



non-sealed  public class Angajat extends Om{

    private  int experienta;
    private float salariu;
    private float bonus;

    public Angajat(String nume, int experienta, float salariu, float bonus) {
        super(nume);
        this.experienta = experienta;
        this.salariu = salariu;
        this.bonus = bonus;
    }

    public int getExperienta() {
        return experienta;
    }

    public float getSalariu() {
        return salariu;
    }

    public float getBonus() {
        return bonus;
    }

    public void setExperienta(int experienta) {
        this.experienta = experienta;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Angajatul se numeste "+getNume()+" are experienta "+experienta+" ani si are un salariu de "+salariu+" cu bonusul "+bonus;
    }
}
