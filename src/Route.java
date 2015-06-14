/*
 * Route.java
 *  Queries:
 *      - insert route
 *      - delete route
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Route {
    public Connection connect = MySQLConnection.getInstance().getConnection();
    public PreparedStatement pstmt = null;
    public Statement stmt = null;
   // public ResultSet resultSet = null;

    private int routeID;
    private String dest;
    private String depart;

    public Route() {}

    // add route
    public boolean insertRoute(int routeID, String dest, String depart) {

        try{
            pstmt = connect.prepareStatement("INSERT into route VALUES (?,?,?)");
            pstmt.setInt(1, routeID);
            pstmt.setString(2, dest);
            pstmt.setString(3, depart);
            pstmt.executeUpdate();
            pstmt.close();

            this.routeID = routeID;
            this.dest = dest;
            this.depart = depart;

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
            int rows = stmt.executeUpdate("DELETE from route WHERE routeID = " + routeID);
            stmt.close();
            return (rows != 0) ? true : false;

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // getter methods
   /* public int getRouteID () {
        return this.routeID;
    }

    public String getDeparture () {
        return this.depart;
    }

    public String getDestination () {
        return this.dest;
    }*/
}

