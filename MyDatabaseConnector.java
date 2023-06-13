
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabaseConnector {

    Connection conn = null;

    public Connection getConn() {
        // Database Connection Set Up

        // variables
        String dbDriver = "com.mysql.jdbc.Driver";
        // String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        String dbName = "sips";
        String dbUsername = "root";
        String dbPassword = "";

        try {
            // load the driver 
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
            System.out.println("Connection created");
            System.out.println("hashcode is: " + conn.hashCode());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("here");
            System.out.println("hashcode is: " + conn.hashCode());
            System.out.println("hashcode now: " + conn.hashCode());
        }

        // return conn;
        return conn;
    }

    // retrieve the products inserted into the database
    public String getAllProducts = "SELECT * FROM products";

    public void destroy() {
        try {
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}