package service;

import bazadate.BazaDate;
import errors.InvalidEmail;
import model.humanresources.Angajat;
import model.humanresources.Cumparator;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

class HumanResourcesService {
    static boolean cmp(String s, String x) {
        return Objects.equals(s, x);

    }

    static void create(InputStream i) {
        AuditService.write_action("HRcreate");
        System.out.println("Angajat sau cumparator [a/c]");
        Scanner s = new Scanner(i);
        String c = s.next();
        if (cmp(c, "a")) {
            System.out.println("introduceti numele, experienta (int), si salariul (float)");
            String nume = s.next();
            int experinta = s.nextInt();
            float salariul = s.nextFloat();
            BazaDate.add(new Angajat(nume, experinta, salariul));
        }
        if (cmp(c, "c")) {
            System.out.println("introduceti numele, adresa email (valida)");
            String nume = s.next();
            String email = s.next();
            try {
                Cumparator tmp = new Cumparator(nume, email);
                BazaDate.add(tmp);

            } catch (InvalidEmail e) {
                System.out.println("adresa email invalida");
            }
        }
    }

    static void delete(InputStream i) {
        AuditService.write_action("HRdelete");
        System.out.println("introduceti numele");
        Scanner s = new Scanner(i);

        BazaDate.removeOm(s.next());
    }

    static void read(InputStream i) {
        AuditService.write_action("HRread");
        Scanner s = new Scanner(i);
        System.out.println("introduceti numele");
        System.out.println(BazaDate.displayOm(s.next()));
    }

    static void update(InputStream i) {
        AuditService.write_action("HRupdate");
        Scanner s = new Scanner(i);
        System.out.println("reintroduceti omul");
        System.out.println("Angajat sau cumparator [a/c]");

        String c = s.next();
        if (cmp(c, "a")) {
            System.out.println("introduceti numele, experienta (int), si salariul (float)");
            String nume = s.next();
            int experinta = s.nextInt();
            float salariul = s.nextFloat();
            BazaDate.updateOm(nume, new Angajat(nume, experinta, salariul));
        }
        if (cmp(c, "c")) {
            System.out.println("introduceti numele, adresa email (valida)");
            String nume = s.next();
            String email = s.next();
            try {
                Cumparator tmp = new Cumparator(nume, email);
                BazaDate.updateOm(nume, tmp);

            } catch (InvalidEmail e) {
                System.out.println("adresa email invalida");
            }
        }

    }

    static void bonus(InputStream i) {
        AuditService.write_action("HRbonus");
        System.out.println("introduceti numele angajatului care primeste bonus in funct de vanzarile lui");
        Scanner s = new Scanner(i);

        var nume = s.next();
        BazaDate.giveBonus(nume);

    }

    static void displayall(InputStream i) {
        AuditService.write_action("HRdisplayall");
        System.out.println(BazaDate.displayallOm());
    }

    static void giveDate(InputStream i) {
        AuditService.write_action("HRgiveDate");
        Scanner s = new Scanner(i);
        System.out.println(" introduceti data (yyyy-MM-dd) si numele cumparatorului");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = s.next();
        String nume = s.next();
        Date parsedDate = null;
        try {
            parsedDate = formatter.parse(date);
        } catch (ParseException p) {
            System.out.println("format de data incorrect !");
        }
        BazaDate.addDateBuyer(parsedDate, nume);


    }

    static void removeDate(InputStream i) {
        AuditService.write_action("HRremoveDate");
        Scanner s = new Scanner(i);
        System.out.println(" introduceti data (yyyy-MM-dd) si numele cumparatorului");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = s.next();
        String nume = s.next();
        Date parsedDate = null;
        try {
            parsedDate = formatter.parse(date);
        } catch (ParseException p) {
            System.out.println("format de data incorrect !");
        }
        BazaDate.removeDateBuyer(parsedDate, nume);
    }

    static void handle(InputStream i) {
        Scanner s = new Scanner(i);
        System.out.println("create/delete/update/read/bonus/giveDate/removeDate/displayall");
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
        if (cmp(q, "bonus")) {
            bonus(i);
        }
        if (cmp(q, "displayall")) {
            displayall(i);
        }
        if (cmp(q, "giveDate")) {
            giveDate(i);
        }
        if (cmp(q, "removeDate")) {
            removeDate(i);
        }
    }
}
