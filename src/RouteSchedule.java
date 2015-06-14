/*
 * RouteSchedule.java
 *  Specifications:
 *      - add/delete a flight schedule to/from a route
 *
 *  Queries:
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RouteSchedule {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    // add route-schedule
    public boolean insertRouteSchedule (int routeID, int fsID) {
        try {
            pstmt = connect.prepareStatement("INSERT INTO airplaneflight VALUES (?, ?)");
            pstmt.setInt(1, routeID);
            pstmt.setInt(2, fsID);
            pstmt.executeUpdate();
            pstmt.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // delete route-schedule
    public boolean deleteRouteSchedule (int routeID, int fsID)  {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate(
                    "DELETE from airplaneflight " +
                            "WHERE planeID = " + routeID +
                            "AND fsID = " + fsID);

            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
