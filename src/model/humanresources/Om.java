package model.humanresources;

import java.util.Objects;

sealed abstract public class Om permits  Angajat,Cumparator{
    String nume;

    public Om(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (! (obj instanceof Angajat) )  return false;
        Om o = (Om) obj;
        return Objects.equals(nume, o.nume);
    }

    @Override
    public int hashCode() {
        return nume.hashCode();
    }
}
