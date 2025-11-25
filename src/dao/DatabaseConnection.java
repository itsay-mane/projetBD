package src.dao;
import java.sql.*;

public class DatabaseConnection {
    static final String CONN_URL = "jdbc:oracle:thin:@oracle1:1521:oracle1";
    static final String USER = "khamlica";
    static final String PASSWD = "khamlica";

    static {
        try {
            //System.out.print("Loading Oracle driver... ");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            //System.out.println("loaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed to load oracle driver");
        }
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(CONN_URL, USER, PASSWD);
    }
    public static void closeConnection(Connection conn) {
        try {
            conn.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            System.err.println("Error closing connection:");
            e.printStackTrace();
        }

    }
}
