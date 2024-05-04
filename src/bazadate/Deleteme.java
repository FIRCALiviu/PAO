package bazadate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Deleteme {
    public static void main(String[] args) {
        String query = "select * from Om";
        try(Statement stmt = DBConfiguration.getConnection().createStatement()
        ;
            ResultSet res  = stmt.executeQuery(query);
        ){
            while (res.next()){
                System.out.println(res.getString(1));
            }
        }
        catch (SQLException e){

        }
    }
}
