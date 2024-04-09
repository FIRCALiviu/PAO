package model.humanresources;
import errors.InvalidEmail;

import java.util.*;
import java.util.regex.*;

final public class Cumparator extends  Om{
    private String email;
    private HashSet<Date> dateVizitare;
    private static final String expresieRegulataEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private  static  final Pattern emailChecker = Pattern.compile(expresieRegulataEmail);

    public Cumparator(String nume, String email) throws InvalidEmail {
        super(nume);
        this.dateVizitare = new HashSet<>();

        Matcher m = emailChecker.matcher(email);
        if (m.matches()) {
            this.email = email;
        }
        else{
            throw new InvalidEmail();
        }
        }
    public  void addDate(Date d){
        dateVizitare.add((Date) d.clone());
    }
    public  void removeDate(Date d){
        dateVizitare.remove(d);
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getNume()+ " este un cumparator cu emailul "+ email+ " cu date vizitate " + dateVizitare.toString();
    }
}
