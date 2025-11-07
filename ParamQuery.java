// javac -d bin -classpath lib/ojdbc6.jar ParamQuery.java
//java -classpath bin:lib/ojdbc6.jar ParamQuery

import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;


public class ParamQuery {

    static final String CONN_URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
    static final String USER = "khamlica";
    static final String PASSWD = "khamlica";

    public ParamQuery () {
            try {
                // CONNEXION
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
    
                // QUIERY
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM emp WHERE ename LIKE ?");
                System.out.println("Nom de l'employe à rechercher dans l'annuraire de l'entreprise: ");
                Scanner scan = new Scanner(System.in);
                String empName = scan.next();
                scan.nextLine();
    
                statement.setString(1, empName);
                ResultSet rset = statement.executeQuery();
    
                if (rset.next()) {
                    System.out.println("Yes !"+ rset.getString("ENAME") + " travaille bien dans l'entreprise!");
                }
                rset.close();
                statement.close();
                conn.close();
    
            } catch (SQLException e) {
                System.err.println("quiery failed");
                e.printStackTrace();
            }
        }
    
        public static void main(String args[]) {
            new ParamQuery();
        }
    } 
