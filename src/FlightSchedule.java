/*
 * FlightSchedule.java
 *  Constraints:
 *      - Each flight schedule needs to be associated with an airplane and a route
 *
 *  Queries:
 *      - insert airplane into flightschedule
 *      - delete airplane from flightschedule
 *      - insert route into flightschedule
 *      - delete route from flightschedule
 */

import java.sql.*;

public class FlightSchedule {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    public FlightSchedule() {}

    // add airplane into flightschedule
    public boolean insertAirplaneIntoFS (int fsID, Timestamp depTime, Timestamp avlTime, int seatsAvail, int planeID, int routeID) {

        try {
            pstmt = connect.prepareStatement("INSERT INTO flightschedule VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, fsID);
            pstmt.setTimestamp(2, depTime);
            pstmt.setTimestamp(3, avlTime);
            pstmt.setInt(4, seatsAvail);
            pstmt.setInt(5, planeID);
            pstmt.setInt(6, routeID);
            pstmt.executeUpdate();
            pstmt.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // delete airplane from flightschedule
    public boolean deleteAirplaneFromFS (int fsID, int planeID, Timestamp depTime, Timestamp avlTime) {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate(
                    "DELETE from flightschedule" +
                            "WHERE flightschedule.fsID = " + fsID +
                            "AND planeID = " + planeID +
                            "AND depTime = " + depTime +
                            "AND avlTime = " + avlTime);
            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // insert route into flightschedule
    public boolean insertRouteIntoFS (int fsID, Timestamp depTime, Timestamp avlTime, int seatsAvail, int planeID, int routeID) {
        try {
            pstmt.setInt(1, fsID);
            pstmt.setTimestamp(2, depTime);
            pstmt.setTimestamp(3, avlTime);
            pstmt.setInt(4, seatsAvail);
            pstmt.setInt(5, planeID);
            pstmt.setInt(6, routeID);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // delete route from flightschedule
    public boolean deleteRouteFromFS (int fsID, int routeID, Timestamp depTime, Timestamp avlTime) {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate(
                    "DELETE from flightschedule" +
                            "WHERE flightschedule.fsID = " + fsID +
                            "AND routeID = " + routeID +
                            "AND depTime = " + depTime +
                            "AND avlTime = " + avlTime);
            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
