package service;

import bazadate.BazaDate;
import errors.InvalidEmail;
import model.humanresources.Angajat;
import model.humanresources.Cumparator;
import model.produse.Camion;
import model.produse.Masina;
import model.produse.Motocicleta;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class MainService {
    public static void process(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("interogati produse sau human ressources?[p/h]");
        if(Objects.equals(s.next(), "h")){
            HumanResourcesService.handle(i);
        }
        else{
            ProductsService.handle(i);
        }

    }

}


class HumanResourcesService {
    static  boolean cmp(String s,String x){
        return Objects.equals(s, x);

    }

    static void create(InputStream i){
        System.out.println("Angajat sau cumparator [a/c]");
        Scanner s = new Scanner(i);
        String c = s.next();
        if(cmp(c,"a")){
            System.out.println("introduceti numele, experienta (int), si salariul (float)");
            String nume = s.next();
            int experinta = s.nextInt();
            float salariul = s.nextFloat();
            BazaDate.add(new Angajat(nume,experinta,salariul));
        }
        if(cmp(c,"c")){
            System.out.println("introduceti numele, adresa email (valida)");
            String nume = s.next();
            String email = s.next();
            try {
                Cumparator tmp = new Cumparator(nume,email);
                BazaDate.add(tmp);

            } catch (InvalidEmail e) {
                System.out.println("adresa email invalida");
            }
        }
    }

    static  void delete(InputStream i){

        System.out.println("introduceti numele");
        Scanner s = new Scanner(i);

        BazaDate.removeOm(s.next());
    }

    static  void read(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("introduceti numele");
        System.out.println(BazaDate.displayOm(s.next()));
    }

    static  void update(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("reintroduceti omul");
        System.out.println("Angajat sau cumparator [a/c]");

        String c = s.next();
        if(cmp(c,"a")){
            System.out.println("introduceti numele, experienta (int), si salariul (float)");
            String nume = s.next();
            int experinta = s.nextInt();
            float salariul = s.nextFloat();
            BazaDate.updateOm(nume,new Angajat(nume,experinta,salariul));
        }
        if(cmp(c,"c")){
            System.out.println("introduceti numele, adresa email (valida)");
            String nume = s.next();
            String email = s.next();
            try {
                Cumparator tmp = new Cumparator(nume,email);
                BazaDate.updateOm(nume,tmp);

            } catch (InvalidEmail e) {
                System.out.println("adresa email invalida");
            }
        }

    }

    static void bonus(InputStream  i){
        System.out.println("introduceti numele angajatului care primeste bonus in funct de vanzarile lui");
        Scanner s = new Scanner(i);

        var nume = s.next();
        BazaDate.giveBonus(nume);

    }
    static void displayall(InputStream i){
        System.out.println(BazaDate.displayallOm());
    }
    static  void handle(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("create/delete/update/read/bonus/displayall");
        var q = s.next();
        if(Objects.equals(q,"create")){
            create(i);
        }
        if(Objects.equals(q,"delete")){
            delete(i);
        }
        if(Objects.equals(q,"update")){
            update(i);
        }
        if(Objects.equals(q,"read")){
            read(i);
        }
        if(cmp(q,"bonus")){
            bonus(i);
        }
        if(cmp(q,"displayall")){
            displayall(i);
        }
    }
}

class ProductsService{
    static  boolean cmp(String s,String x){
        return Objects.equals(s, x);

    }
    static  void create(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("Masina, sau camion sau motocicleta ?[m/c/mo]");
        var q = s.next();
        if(cmp(q,"m")){
            System.out.println("Masina : float pret, String codSerial, int nrLocuri, float kilometrii, int putereMotor, String culoare, String poluare");
            BazaDate.add(new Masina(s.nextFloat(),s.next(),s.nextInt(),s.nextFloat(),s.nextInt(),s.next(),s.next()));
        }
        if(cmp(q,"c")){
            System.out.println("Camion : String codSerial, float pret, int putereMotor, String poluare, double volumMarfa, float lungime, float latime, float inaltime");
            BazaDate.add(new Camion(s.next(),s.nextFloat(),s.nextInt(),s.next(),s.nextDouble(),s.nextFloat(),s.nextFloat(),s.nextFloat()));
        }
        if(cmp(q,"mo")){
            System.out.println("Motocicleta(float pret, String codSerial, int nrLocuri, float kilometrii, int hp)");
            BazaDate.add(new Motocicleta(s.nextFloat(),s.next(),s.nextInt(),s.nextFloat(),s.nextInt()));
        }
    }
    static  void delete(InputStream i)
    {
        Scanner s = new Scanner(i);
        System.out.println("introduceti codul serial al vehicului de sters");
        BazaDate.removeVehicul(s.next());
    }
    static  void read(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("introduceti codul serial apart. vehiculului de analizat");
        System.out.println(BazaDate.displayVehicul(s.next()));
    }

    static  void update(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("Reintroduceti vehiculul");
        System.out.println("Masina, sau camion sau motocicleta ?[m/c/mo]");
        var q = s.next();
        if(cmp(q,"m")){
            System.out.println("Masina : float pret, String codSerial, int nrLocuri, float kilometrii, int putereMotor, String culoare, String poluare");
            float pret = s.nextFloat();
            String cod = s.next();
            BazaDate.updateVehicul(cod,new Masina(pret,cod,s.nextInt(),s.nextFloat(),s.nextInt(),s.next(),s.next()));
        }
        if(cmp(q,"c")){
            System.out.println("Camion : String codSerial, float pret, int putereMotor, String poluare, double volumMarfa, float lungime, float latime, float inaltime");
            var nume = s.next();
            BazaDate.updateVehicul(nume,new Camion(nume,s.nextFloat(),s.nextInt(),s.next(),s.nextDouble(),s.nextFloat(),s.nextFloat(),s.nextFloat()));
        }
        if(cmp(q,"mo")){
            System.out.println("Motocicleta(float pret, String codSerial, int nrLocuri, float kilometrii, int hp)");

            var pret = s.nextFloat();
            var cod =s.next();
            BazaDate.updateVehicul(cod,new Motocicleta(pret,cod,s.nextInt(),s.nextFloat(),s.nextInt()));
        }

    }

    static  void  vinde(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("cod serial, nume cumparator, nume vanzator");
        BazaDate.setCumparator(s.next(),s.next(),s.next());
    }
    static void displayall(InputStream  i){
        System.out.println(BazaDate.displayallItem());
    }
    static  void handle(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("create/delete/update/read/vinde/displayall");
        var q = s.next();

        if(Objects.equals(q,"create")){
            create(i);
        }
        if(Objects.equals(q,"delete")){
            delete(i);
        }
        if(Objects.equals(q,"update")){
            update(i);
        }
        if(Objects.equals(q,"read")){
            read(i);
        }
        if(cmp(q,"vinde")){
            vinde(i);
        }
        if(cmp(q,"displayall")){
            displayall(i);
        }
    }
}

