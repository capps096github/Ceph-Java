
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class MyDatabaseConnector {

    // this is the Connection object that will be used to establish connection with
    // the database
    // it is declared here so that it can be used in all the methods of this class
    // it is initialized in the getConn() method
    // but internally, it is assigned to the connection object returned by the
    // getConnection() method of DriverManager class
    Connection conn = null;

    public Connection getConn() {
        // Database Connection Set Up

        // variables
        // this is the driver for mysql and it is used to load the driver
        String dbDriver = "com.mysql.jdbc.Driver";

        // this is the URL to the database and it is used to establish connection with
        // the database
        String dbURL = "jdbc:mysql://localhost:3306/";

        // this is the name of the database and is combined with the URL to establish
        // connection with the database
        String dbName = "sips";

        // these are the username and password of the database and are used to establish
        // connection with the database
        String dbUsername = "root";
        String dbPassword = "";

        try {
            // load or register the driver
            Class.forName(dbDriver);

            // create the connection once the driver is registered(loaded)
            // getConnection() method of DriverManager class is used to establish connection
            // with the database
            // its parameters are the URL, username and password of the database
            // URL syntax: jdbc:mysql://hostname:port/databasename
            conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);

            // ? 1. execute a query to the database using Statement object
            Statement stmt = conn.createStatement();

            // create a table in the database
            String createTable = "CREATE TABLE IF NOT EXISTS products (id int(11) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, price double NOT NULL, PRIMARY KEY (id))";
            // create a query to insert data into the database
            String insertData = "INSERT INTO products (name, price) VALUES ('iPhone 6', 600), ('iPhone 6S', 700)";

            // execute the query
            stmt.executeUpdate(createTable);
            stmt.executeUpdate(insertData);

            // ? 2. execute a query to the database using PreparedStatement object
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)");

            // set the parameters of the PreparedStatement object
            // syntax: pstmt.setDatatype(position, value);
            pstmt.setString(1, "iPhone 6X");
            pstmt.setDouble(2, 600);
            // for int
            // pstmt.setInt(3, 1);

            // execute the query
            pstmt.executeUpdate();

            // ? 3. Using a CallableStatement object
            // create a query to insert data into the database
            String insertData2 = "INSERT INTO products (name, price) VALUES ('iPhone 6', 600)";

            // create a CallableStatement object
            CallableStatement cstmt = conn.prepareCall(insertData2);

            // execute the query
            cstmt.executeUpdate();

            // ? 4. Get results from the database via the ResultSet object
            // create a query to retrieve data from the database
            String retrieveData = "SELECT * FROM products";

            // execute the query via the Statement object executeQuery() method that returns
            // a ResultSet object
            ResultSet rs = stmt.executeQuery(retrieveData);

            // retrieve the data from the ResultSet object from a prepared statement
            // ResultSet rst = pstmt.executeQuery(retrieveData);

            // iterate through the result set
            while (rs.next()) {
                // get the data from the result set
                // syntax: rs.getDatatype(columnName);
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                // print the data
                System.out.println("id: " + id + ", name: " + name + ", price: " + price);
            }

            System.out.println("Connection created");
            System.out.println("hashcode is: " + conn.hashCode());
        } catch (ClassNotFoundException | SQLException e) {
            // print
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
            // close the connection to the database, this helps to free up resources
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}