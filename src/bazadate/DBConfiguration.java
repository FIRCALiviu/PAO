package bazadate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConfiguration {


        private static final String DB_URL = "jdbc:mysql://localhost:3306/DealershipDb";
            private static final String USER = "application";
        private static final String PASSWORD = "app12";

        private static Connection databaseConnection;

        private DBConfiguration() {
        }

        public static Connection getConnection() {
            try {
                if (databaseConnection == null || databaseConnection.isClosed()) {
                    databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return databaseConnection;
        }


}
