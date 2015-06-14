import java.sql.*;

public class MySQLConnection {
    private static MySQLConnection sqlConnection = null;
    private Connection connection = null;

    private String dbName = "hello";
    private String url = "jdbc:mysql://localhost:3306/" + dbName;
    private String username = "root";
    private String password = "";

    private Statement statement = null;
    private ResultSet resultSet = null;

    public void connectToDatabse () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL-JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL-JDBC Driver Registered!");

        try {
            connection = DriverManager
                    .getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

       /* if (connection != null) {
            System.out.println("Connected to " + dbName + " database!");
        } else {
            System.out.println("Failed to make connection!");
        }*/
    }

    // reads and prints database contents
    public void readDatabase () throws SQLException{
        System.out.println("What's in " + dbName + " database ?");

        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from route");
        printResultSet(resultSet);

        //closeRS();
    }

    private void printResultSet (ResultSet rs) throws SQLException {
        while (rs.next()) {
            int routeID = rs.getInt(1);
            String dest = rs.getString(2);
            String depart = rs.getString(3);
            System.out.println("RouteID: " + routeID);
            System.out.println("Destination: " + dest);
            System.out.println("Departure: " + depart);
        }
    }

    // close
    public void closeConnection () {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
    }

    // get a new instance of MySQLConnection
    public static MySQLConnection getInstance() {
        if (sqlConnection == null)
            sqlConnection = new MySQLConnection();
        return sqlConnection;

    }

    // get a connected connection
    public Connection getConnection() {
        if (connection == null) {
            connectToDatabse();
            return this.connection;
        } else
            return this.connection;
    }
}
