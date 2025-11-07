// javac -d bin -classpath lib/ojdbc6.jar SimpleQuery.java
//java -classpath bin:lib/ojdbc6.jar SimpleQuery

import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;

public class TestQuery {

    static final String CONN_URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
    static final String USER = "khamlica";
    static final String PASSWD = "khamlica";


    public TestQuery () {

        try {
            // CONNEXION
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);

            // QUIERY
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM emp");
            while (rset.next()) {
                System.out.println(rset.getString("ENAME")); // exemple d'affichage
        }

        rset.close();
        stmt.close();
        conn.close();

        } catch (SQLException e) {
            System.err.println("quiery failed");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new TestQuery();
    }
} 


