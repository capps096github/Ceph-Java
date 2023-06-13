import java.sql.*;

public class DatabaseApp {

    public static void main(String[] args) {
        // Variables
        // driverName
        String driverName = "com.mysql.jbdc.Driver";

        // dbAddress
        String dbAddress = "jdbc:mysql://localhost:3306/";

        // dBName
        String dbName = "sips";

        // dbUrl
        String dbUrl = dbAddress + dbName;

        // username and password
        String userName = "root";
        // password
        String password = "";

        try {

            // 1: Register driver
            Class.forName(driverName);
            // 2: Establish connection
            Connection dbConnection = DriverManager.getConnection(dbUrl, userName, password);

            // print that connection was created
            System.out.println("Connection was created");

            // 3: Start connecting to DB by creating Statements
            Statement statement = dbConnection.createStatement();

            // create a students table with id, name, course, year
            String createStudentTable = "CREATE TABLE students (id int(11) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, course varchar(255) NOT NULL, year int(11) NOT NULL, PRIMARY KEY (id))";

            // create a query to insert data into the database
            String insertData = "INSERT INTO students (name, course, year) VALUES ('John Doe', 'Computer Science', 2), ('Jane Doe', 'Computer Science', 3)";

            // execute the updates to the database
            statement.executeUpdate(createStudentTable);
            statement.executeUpdate(insertData);

            // print that data has been inserted
            System.out.println("Data has been inserted");

            // Retrieve data from the database
            String retrieveStudentData = "SELECT * FROM students";
            // String retrieveStudentData = "SELECT * FROM students WHERE id = 1";

            // execute query to retrieve data from the database
            ResultSet resultSet = statement.executeQuery(retrieveStudentData);

            // loop through the result set and print the data
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Course: " + resultSet.getString("course"));
                System.out.println("Year: " + resultSet.getInt("year"));
            }

            // close the connection
            dbConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
