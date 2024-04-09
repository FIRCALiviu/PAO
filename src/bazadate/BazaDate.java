package bazadate;

import model.humanresources.Angajat;
import model.humanresources.Cumparator;
import model.humanresources.Om;
import model.produse.Autovehicul;

import java.util.HashSet;
import java.util.Objects;

public class BazaDate {
    static private HashSet<Om> oameni = new HashSet<>();
    static  private HashSet<Autovehicul> inventar = new HashSet<>();

    public  static void add(Om o){
        oameni.add(o);
    }
    public  static  void remove (Om o){
        oameni.remove(o);
    }
    public  static  void add(Autovehicul a){
        inventar.add(a);
    }
    public  static void remove(Autovehicul a){
        inventar.remove(a);
    }

    public  static String displayOm(String nume){
        for(Om om:oameni){
            if (Objects.equals(om.getNume(), nume)) return om.toString();
        }
        return  "";
    }
    public  static  String displayVehicul(String cod){
        for(Autovehicul v:inventar){
            if(Objects.equals(v.getCodSerial(),cod)) return v.toString();
        }
        return  "";
    }
    public  static  void Update(String nume, Om o){
        for(Om om:oameni){
            if (Objects.equals(om.getNume(), nume)){
                oameni.remove(om);
                oameni.add(o);
                return;
            }
        }
    }
    public  static  void Update(String cod,Autovehicul a){
        for(Autovehicul x:inventar){
            if(Objects.equals(x.getCodSerial(),a.getCodSerial())){
                inventar.remove((x));
                inventar.add(a);
                return;
            }
        }
    }

    public  static  StringBuilder displayInventar(){
        StringBuilder b = new StringBuilder();
        for(Autovehicul a:inventar){
            b.append('\n');
            b.append(a.toString());
        }
        return b;
    }

    public  static  StringBuilder displayAngajati(){
        StringBuilder b = new StringBuilder();
        for (Om o:oameni){
            if(o instanceof Angajat){
                b.append(o.toString());
                b.append('\n');
            }
        }
        return b;
    }

    public  static  StringBuilder displayCumparatori(){
        StringBuilder b = new StringBuilder();
        for (Om o:oameni){
            if(o instanceof Cumparator){
                b.append(o.toString());
                b.append('\n');
            }
        }
        return b;
    }


}
