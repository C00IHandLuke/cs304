/*
 * AirplaneFlight.java
 *  Queries:
 *      - insert & delete airplaneflight
 *      - update airplaneflight
 */

import java.sql.*;

public class AirplaneFlight {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    public AirplaneFlight () {}

    // add airplane-flight
    public boolean insertAirplaneFlight (int planeID, int fsID) {
        try {
            pstmt = connect.prepareStatement("INSERT INTO airplaneflight VALUES (?, ?)");
            pstmt.setInt(1, planeID);
            pstmt.setInt(2, fsID);
            pstmt.executeUpdate();
            pstmt.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // delete airplane-flight
    public boolean deleteAirplaneFlight (int planeID, int fsID) {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate(
                    "DELETE from airplaneflight" +
                            " WHERE planeID = " + planeID +
                            " AND fsID = " + fsID);

            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // update flightschedule associated with an airplane
    public boolean updateAirplaneFlight (int planeID, int newFlightScheduleID) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE airplaneflight SET fsID = "+ newFlightScheduleID + " WHERE planeID = " + planeID);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

}
