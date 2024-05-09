package service;

import bazadate.BazaDate;
import model.autovehicles.Camion;
import model.autovehicles.Masina;
import model.autovehicles.Motocicleta;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

class ProductsService {
    static boolean cmp(String s, String x) {
        return Objects.equals(s, x);

    }

    static void create(InputStream i) {
        AuditService.write_action("PScreate");
        Scanner s = new Scanner(i);
        System.out.println("Masina, sau camion sau motocicleta ?[m/c/mo]");
        var q = s.next();
        if (cmp(q, "m")) {
            System.out.println("Masina : float pret, String codSerial, int nrLocuri, float kilometrii, int putereMotor, String culoare, String poluare");
            BazaDate.add(new Masina(s.nextFloat(), s.next(), s.nextInt(), s.nextFloat(), s.nextInt(), s.next(), s.next()));
        }
        if (cmp(q, "c")) {
            System.out.println("Camion : String codSerial, float pret, int putereMotor, String poluare, double volumMarfa, float lungime, float latime, float inaltime");
            BazaDate.add(new Camion(s.next(), s.nextFloat(), s.nextInt(), s.next(), s.nextDouble(), s.nextFloat(), s.nextFloat(), s.nextFloat()));
        }
        if (cmp(q, "mo")) {
            System.out.println("Motocicleta(float pret, String codSerial, int nrLocuri, float kilometrii, int hp)");
            BazaDate.add(new Motocicleta(s.nextFloat(), s.next(), s.nextInt(), s.nextFloat(), s.nextInt()));
        }
    }

    static void delete(InputStream i) {
        AuditService.write_action("PSdelete");
        Scanner s = new Scanner(i);
        System.out.println("introduceti codul serial al vehicului de sters");
        BazaDate.removeVehicul(s.next());
    }

    static void read(InputStream i) {
        AuditService.write_action("PSread");
        Scanner s = new Scanner(i);
        System.out.println("introduceti codul serial apart. vehiculului de analizat");
        System.out.println(BazaDate.displayVehicul(s.next()));
    }

    static void update(InputStream i) {
        AuditService.write_action("PSupdate");
        Scanner s = new Scanner(i);
        System.out.println("Reintroduceti vehiculul");
        System.out.println("Masina, sau camion sau motocicleta ?[m/c/mo]");
        var q = s.next();
        if (cmp(q, "m")) {
            System.out.println("Masina : float pret, String codSerial, int nrLocuri, float kilometrii, int putereMotor, String culoare, String poluare");
            float pret = s.nextFloat();
            String cod = s.next();
            BazaDate.updateVehicul(cod, new Masina(pret, cod, s.nextInt(), s.nextFloat(), s.nextInt(), s.next(), s.next()));
        }
        if (cmp(q, "c")) {
            System.out.println("Camion : String codSerial, float pret, int putereMotor, String poluare, double volumMarfa, float lungime, float latime, float inaltime");
            var nume = s.next();
            BazaDate.updateVehicul(nume, new Camion(nume, s.nextFloat(), s.nextInt(), s.next(), s.nextDouble(), s.nextFloat(), s.nextFloat(), s.nextFloat()));
        }
        if (cmp(q, "mo")) {
            System.out.println("Motocicleta(float pret, String codSerial, int nrLocuri, float kilometrii, int hp)");

            var pret = s.nextFloat();
            var cod = s.next();
            BazaDate.updateVehicul(cod, new Motocicleta(pret, cod, s.nextInt(), s.nextFloat(), s.nextInt()));
        }

    }

    static void vinde(InputStream i) {
        AuditService.write_action("PSvinde");
        Scanner s = new Scanner(i);
        System.out.println("cod serial, nume cumparator, nume vanzator");
        BazaDate.setCumparator(s.next(), s.next(), s.next());
    }

    static void displayall(InputStream i) {
        AuditService.write_action("PSdisplayall");
        System.out.println(BazaDate.displayallItem());
    }

    static void handle(InputStream i) {
        Scanner s = new Scanner(i);
        System.out.println("create/delete/update/read/vinde/displayall");
        var q = s.next();

        if (Objects.equals(q, "create")) {
            create(i);
        }
        if (Objects.equals(q, "delete")) {
            delete(i);
        }
        if (Objects.equals(q, "update")) {
            update(i);
        }
        if (Objects.equals(q, "read")) {
            read(i);
        }
        if (cmp(q, "vinde")) {
            vinde(i);
        }
        if (cmp(q, "displayall")) {
            displayall(i);
        }
    }
}
