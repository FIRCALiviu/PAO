package bazadate;

import model.humanresources.Angajat;
import model.humanresources.Cumparator;
import model.humanresources.Om;
import model.produse.Autovehicul;

import javax.management.ValueExp;
import java.util.*;

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
    public  static  void giveBonus(String angajat){
        float sum = 0;
        for(Map.Entry<String,Autovehicul> pair : inventar.entrySet()){
            Autovehicul a= pair.getValue();
            if(Objects.equals(a.getVanzatorul(),angajat)){
                sum+=a.getPret()*0.05;
            }
        }
        if (oameni.containsKey(angajat)) {
            Om i = oameni.get(angajat);
            if(i instanceof Angajat){
                ((Angajat) i).setBonus(sum);
            }

        }
    }

    public static void setCumparator(String codProdus, String numeCumparator, String numeVanzator){
        if(inventar.containsKey(codProdus)){
            inventar.get(codProdus).setCumparator((numeCumparator));
            inventar.get(codProdus).setVanzatorul(numeVanzator);
        }
    }
    public static void removeOm(String nume){
        oameni.remove(nume);
    }
    public  static void removeVehicul(String cod){
        inventar.remove(cod);
    }
    public  static  String displayOm(String nume){
        if(oameni.get(nume)!=null){
            return oameni.get(nume).toString();
        }
        return "404 not found";
    }
    public static  String displayVehicul(String cod){
        if(inventar.get(cod)!=null){
            return inventar.get(cod).toString();
        }
        return "404 not found";
    }
    public static  void updateOm(String nume, Om o){
        oameni.put(nume,o);
    }
    public static  void updateVehicul(String cod, Autovehicul a){
        inventar.put(cod,a);
    }

    public  static  StringBuilder displayallOm(){
        StringBuilder b = new StringBuilder();
        for(Map.Entry<String,Om> pair : oameni.entrySet()){
            b.append('\n');
            b.append(pair.getValue().toString());
        }
        return b;
    }
    public  static  StringBuilder displayallItem(){
        StringBuilder b = new StringBuilder();
        for(Map.Entry<String,Autovehicul> pair: inventar.entrySet()){
            b.append('\n')
                    ;
            b.append(pair.getValue().toString());
        }
        return b;
    }
    public  static void  addDateBuyer(Date d,String name){
        Om x = oameni.get(name);
        if(x!=null && x instanceof  Cumparator){
            ((Cumparator) x).addDate(d);
        }
    }
    public  static  void removeDateBuyer(Date d,String nume){
        Om x = oameni.get(nume);
        if(x!=null && x instanceof  Cumparator){
            ((Cumparator) x).removeDate(d);
        }

    }

}
