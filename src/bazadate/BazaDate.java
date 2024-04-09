package bazadate;

import model.humanresources.Angajat;
import model.humanresources.Cumparator;
import model.humanresources.Om;
import model.produse.Autovehicul;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class BazaDate {
    static  private  final HashMap<String,Om> oameni=new HashMap<>();
    static  private  final HashMap<String,Autovehicul> inventar= new HashMap<>();

    public static void add(Om o){
        if(oameni.containsKey(o.getNume())){
            System.out.println("Exista deja acest om in DB");
            return;
        }
        oameni.put(o.getNume(),o);
    }
    public static void add(Autovehicul a ){
        if(inventar.containsKey(a.getCodSerial())){
            System.out.println("autovehiculul  deja exista");
            return;
        }
        inventar.put(a.getCodSerial(),a);

    }
    public static void removeOm(String nume){
        oameni.remove(nume);
    }
    public  static void removeVehicul(String cod){
        inventar.remove(cod);
    }
    public  static  String displayOm(String nume){
        if(inventar.get(nume)!=null){
            return inventar.get(nume).toString();
        }
        return "404 not found";
    }
    public static  String displayVehicul(String cod){
        if(oameni.get(cod)!=null){
            return oameni.get(cod).toString();
        }
        return "404 not found";
    }
    public static  void updateOm(String nume, Om o){
        oameni.put(nume,o);
    }
    public static  void updateVehicul(String cod, Autovehicul a){
        inventar.put(cod,a);
    }


}
