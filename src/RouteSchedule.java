/*
 * RouteSchedule.java
 *  Queries:
 *      - insert & delete routeschedule
 *      - update routeschedule
 */

import java.sql.*;

public class RouteSchedule {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    // add route-schedule
    public boolean insertRouteSchedule (int routeID, int fsID) {
        try {
            pstmt = connect.prepareStatement("INSERT INTO routeschedule VALUES (?, ?)");
            pstmt.setInt(1, routeID);
            pstmt.setInt(2, fsID);
            pstmt.executeUpdate();
            pstmt.close();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // delete route-schedule
    public boolean deleteRouteSchedule (int routeID, int fsID)  {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate(
                    "DELETE from routeschedule " +
                            " WHERE routeID = " + routeID +
                            " AND fsID = " + fsID);

            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // update routeschedule associated with an airplane
    public boolean updateAirplaneFlight (int routeID, int newFlightScheduleID) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE routeschedule SET fsID = "+ newFlightScheduleID + " WHERE routeID = " + routeID);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

}
