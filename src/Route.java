/*
 * Route.java
 *  Queries:
 *      - insert & delete route
 *      - update departure & destination
 *      - search for route & return route-id
 */

import java.sql.*;

public class Route {
    public Connection connect = MySQLConnection.getInstance().getConnection();
    public PreparedStatement pstmt = null;
    public Statement stmt = null;
    public ResultSet resultSet = null;

    public Route() {}

    // add route
    public boolean insertRoute(int routeID, String destination, String departure) {
        try{
            pstmt = connect.prepareStatement("INSERT INTO route VALUES (?,?,?)");
            pstmt.setInt(1, routeID);
            pstmt.setString(2, destination);
            pstmt.setString(3, departure);
            pstmt.executeUpdate();
            pstmt.close();

            return true;

        }catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return false;
        }
    }

    // delete route
    public boolean deleteRoute(int routeID) {
        try{
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM route WHERE routeID = " + routeID);
            stmt.close();
            return (rows != 0) ? true : false;

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // update route
    public boolean updateDeparture (int routeID, String newDeparture) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE route SET departure = "+ newDeparture + " WHERE routeID = " + routeID);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateDestination (int routeID, String newDestination) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE route SET departure = "+ newDestination + " WHERE routeID = " + routeID);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    // search for route and return route ID
    public int searchForRoute (String departure, String destination) {
        int routeID = 0;
        try {
            resultSet = stmt.executeQuery("SELECT * FROM route WHERE departure = " + departure + " AND destination = " + destination);
            while (resultSet.next()) {
                routeID = resultSet.getInt(1);
            }
            return routeID;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}

