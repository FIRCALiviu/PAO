package bazadate;

import errors.InvalidEmail;
import model.autovehicles.Camion;
import model.autovehicles.Masina;
import model.autovehicles.Motocicleta;
import model.humanresources.Angajat;
import model.humanresources.Cumparator;
import model.humanresources.Om;
import model.autovehicles.Autovehicul;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BazaDate {
    private static String processString(String toSqlSTring){
        if (toSqlSTring==null) return null;
        return "'"+toSqlSTring+"'";
    }

    public static void add(Om o){
        String insertOm = String.format("insert into Om values(%s)", processString(o.getNume()));
        String insertAngajat;
        String insertCumparator;

        try(Statement stmt = DBConfiguration.getConnection().createStatement();

        ){
            if(o instanceof Angajat){
                insertAngajat = String.format("insert into Angajat values(%s,%f,%d,%f)", processString(processString(o.getNume())),((Angajat) o).getSalariu(),((Angajat) o).getExperienta(),((Angajat) o).getBonus());

                stmt.executeUpdate(insertOm);
                stmt.executeUpdate(insertAngajat);
            }
            else if(o instanceof  Cumparator){
                insertCumparator = String.format("insert into Cumparator values(%s,%s)", processString(o.getNume()),processString(((Cumparator) o).getEmail()));
                stmt.executeUpdate(insertOm);
                stmt.executeUpdate(insertCumparator);
            }


        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void add(Autovehicul a ){
        String insertAutovehicul = String.format("insert into Autovehicul values(%s,%f,%d,%f,%s,%s)", processString(a.getCodSerial()),a.getPret(),a.getNrLocuri(),a.getKilometrii(),processString(a.getVanzatorul()),processString(a.getCumparator()));
        String insertMotocicleta;
        String insertMasina;
        String insertCamion;
        try(Statement stmt = DBConfiguration.getConnection().createStatement()){
            if(a instanceof Motocicleta){
                insertMotocicleta = String.format("insert into Motocicleta values(%s,%d)", processString(a.getCodSerial()),((Motocicleta) a).getHorsepower());
                stmt.executeUpdate(insertAutovehicul);
                stmt.executeUpdate(insertMotocicleta);
            }
            else if(a instanceof Camion){
                insertMasina = String.format("insert into Masina values(%s,%d,%s,%s)", processString(a.getCodSerial()),((Camion) a).getPutereMotor(),processString(((Camion) a).getPoluare()),((Camion) a).getCuloare());
                insertCamion = String.format("insert into Camion values(%s,%f,%f,%f,%f)", processString(a.getCodSerial()),((Camion) a).getVolumMarfa(),((Camion) a).getLungime(),((Camion) a).getLatime(),((Camion) a).getInaltime());
                stmt.executeUpdate(insertAutovehicul);
                stmt.executeUpdate(insertMasina);
                stmt.executeUpdate(insertCamion);
            }
            else if (a instanceof Masina){
                insertMasina = String.format("insert into Masina values(%s,%d,%s,%s)", processString(a.getCodSerial()),((Masina) a).getPutereMotor(),processString(((Masina) a).getPoluare()),processString(((Masina) a).getCuloare()));
                stmt.executeUpdate(insertAutovehicul);
                stmt.executeUpdate(insertMasina);

            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public  static  void giveBonus(String angajat){
        String formatUpdate = "update Angajat set bonus = %f where nume = %s";
        String query = String.format("select pret from Autovehicul where vanzatorul = %s", processString(angajat));
        try(Statement stmt = DBConfiguration.getConnection().createStatement();

            ResultSet res = stmt.executeQuery(query);
        ){
            float sum = 0;
            while (res.next()){
                sum+= res.getFloat(1)*0.07f;
            }
            if (Objects.equals(sum,0) ){
                return;
            }
            int n = stmt.executeUpdate(String.format(formatUpdate, sum,processString(angajat)));
            if(n!=0){
                System.out.println("Bonus succesfully gived");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void setCumparator(String codProdus, String numeCumparator, String numeVanzator){
        String updateFormat = "update Autovehicul set cumparator = %s, vanzatorul = %s where codSerial = %s";
        try (Statement stmt = DBConfiguration.getConnection().createStatement()){
            int n = stmt.executeUpdate(String.format(updateFormat, processString(numeCumparator),processString(numeVanzator),processString(codProdus)));
            if (n!=0){
                System.out.println("updated with succes");
            }
            else{
                System.out.println("failure, maybe you type a key wrong or the data does not exist");
            }
        }
        catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }
    public static void removeOm(String nume){
        String removeAngajati = "delete from Angajat where nume = %s";
        String removeOm = "delete from Om where nume = %s";
        String removeCumparator = "delete from Cumparator where nume = %s";
        String removeDateViz = "delete from DateVizitate where NumeCumparator = %s";
        try(Statement stmt = DBConfiguration.getConnection().createStatement()){
            stmt.executeUpdate(String.format(removeDateViz, processString(nume)));
            stmt.executeUpdate(String.format(removeAngajati, processString(nume)));
            stmt.executeUpdate(String.format(removeCumparator, processString(nume)));
            stmt.executeUpdate(String.format(removeOm, processString(nume)));
        }
        catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }
    public  static void removeVehicul(String cod){
        String removeAuto = "delete from Autovehicul where codSerial = %s";
        String removeMotocicleta = "delete from Motocicleta where codSerial = %s";
        String removeMasina = "delete from Masina where codSerial = %s";
        String removeCamion = "delete from Camion where codSerial = %s";
        try(Statement stmt = DBConfiguration.getConnection().createStatement()){
            stmt.executeUpdate(String.format(removeCamion, processString(cod)));
            stmt.executeUpdate(String.format(removeMasina, processString(cod)));
            stmt.executeUpdate(String.format(removeMotocicleta, processString(cod)));
            stmt.executeUpdate(String.format(removeAuto, processString(cod)));
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  static  String displayOm(String nume){
        String getAngajat = "select * from Angajat where nume = %s";
        String getOm = "select * from Om where nume = %s";
        String getCumparator = "select * from Cumparator where nume = %s";
        String getDate= "select * from DateVizitate where NumeCumparator = %s";
        try(Statement stmt = DBConfiguration.getConnection().createStatement();
            Statement stmt2 = DBConfiguration.getConnection().createStatement();
            Statement stmt3 = DBConfiguration.getConnection().createStatement();
            Statement stmt4 = DBConfiguration.getConnection().createStatement();
            ResultSet cumparator  = stmt.executeQuery(String.format(getCumparator, processString(nume)));
            ResultSet angajat = stmt2.executeQuery(String.format(getAngajat, processString(nume)));
            ResultSet Om = stmt3.executeQuery(String.format(getOm, processString(nume)));
            ResultSet date = stmt4.executeQuery(String.format(getDate, processString(nume)));
        ){
            Om.next();
            if(cumparator.next()){

                Cumparator c =  new Cumparator(Om.getString(1),cumparator.getString(2));
                while (date.next()){
                    c.addDate(date.getDate(1));
                }
                return c.toString();
            }
            else if(angajat.next()){
                return new Angajat(Om.getString(1),angajat.getInt(3),angajat.getFloat(2),angajat.getFloat(4)).toString();
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (InvalidEmail e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static  String displayVehicul(String cod){
        String getAuto = "select * from Autovehicul where codSerial = %s";
        String getMotocicleta = "select * from Motocicleta where codSerial = %s";
        String getMasina = "select * from Masina where codSerial = %s";
        String getCamion = "select * from Camion where codSerial = %s";
        try(Statement stmt = DBConfiguration.getConnection().createStatement();
            Statement stmt2 = DBConfiguration.getConnection().createStatement();
            Statement stmt3 = DBConfiguration.getConnection().createStatement();
            Statement stmt4 = DBConfiguration.getConnection().createStatement();
            ResultSet Auto = stmt.executeQuery(String.format(getAuto, processString(cod)));
            ResultSet motocicleta = stmt2.executeQuery(String.format(getMotocicleta, processString(cod)));
            ResultSet masina = stmt3.executeQuery(String.format(getMasina, processString(cod)));
            ResultSet camion = stmt4.executeQuery(String.format(getCamion, processString(cod)));

        ){
            Auto.next();
            if(camion.next()){
                masina.next();
                Camion c =  new Camion(Auto.getString(1),Auto.getFloat(2),masina.getInt(2),masina.getString(3),camion.getFloat(2),camion.getFloat(3),camion.getFloat(4),camion.getFloat(5));
                c.setVanzatorul(Auto.getString(5));
                c.setCumparator(Auto.getString(6));
                return c.toString();
            }
            else if(motocicleta.next()){
                Motocicleta c = new Motocicleta(Auto.getFloat(2),Auto.getString(1),Auto.getInt(3),Auto.getFloat(4),motocicleta.getInt(2));c.setVanzatorul(Auto.getString(5));
                c.setVanzatorul(Auto.getString(5));
                c.setCumparator(Auto.getString(6));
                return c.toString();
            }
            else if (masina.next()){
                Masina c = new Masina(Auto.getFloat(2),Auto.getString(1),Auto.getInt(3),Auto.getFloat(4),masina.getInt(2),masina.getString(4),masina.getString(3));
                c.setVanzatorul(Auto.getString(5));
                c.setCumparator(Auto.getString(6));
                return c.toString();
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return null;
    }
    public static  void updateOm(String nume, Om o){
        String updateAngajat = "update Angajat set salariu = %f, experienta = %d where nume = %s";
        String updateCumparator = "update Cumparator set email = %s where nume = %s";
        try(Statement stmt = DBConfiguration.getConnection().createStatement()) {
            if (o instanceof Angajat) {
                stmt.executeUpdate(String.format(updateAngajat, ((Angajat) o).getSalariu(),((Angajat) o).getExperienta(),processString(nume)));

            } else if (o instanceof Cumparator) {
                stmt.executeUpdate(String.format(updateCumparator, processString(((Cumparator) o).getEmail()),processString(nume)));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static  void updateVehicul(String cod, Autovehicul a){
        removeVehicul(cod);
        add(a);
    }

    public  static  StringBuilder displayallOm(){
        StringBuilder b = new StringBuilder();
        String query = "select nume from Om";
        try(Statement stmt = DBConfiguration.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query)
        ){
            while (res.next()){
                b.append('\n');
                b.append(displayOm(res.getString(1)));
                b.append('\t');
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return b;
    }
    public  static  StringBuilder displayallItem(){
        StringBuilder b = new StringBuilder();
        String query= "select codSerial from Autovehicul";
        try(Statement stmt = DBConfiguration.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);

        ){
            while (res.next()){
                b.append('\n');
                b.append('\t');
                b.append(displayVehicul(res.getString(1)));
                b.append('\n');

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return b;
    }
    public  static void  addDateBuyer(Date d,String name){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String res = sdf.format(d);
        String query = String.format("insert into DateVizitate values(date %s,%s)",processString(res), processString(name));
        try(Statement stmt = DBConfiguration.getConnection().createStatement()
        ){
        stmt.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  static  void removeDateBuyer(Date d,String nume){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String res = sdf.format(d);
        String query = String.format("delete from DateVizitate where Data = date %s and NumeCumparator = %s ",processString(res), processString(nume));
        try(Statement stmt = DBConfiguration.getConnection().createStatement()){
            stmt.executeUpdate(query);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
