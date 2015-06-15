/*
 * Ticket.java
 *  Queries:
 *      - insert & delete ticketflight
 *      - update cancellation fee associated with a flight schedule
 */

import java.sql.*;

public class ticketFlight extends Ticket {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    public ticketFlight () {}

    // add ticketflight
    public boolean insertTicketFlight (int cancelFee, int flightScheduleID) {
        try {
            pstmt = connect.prepareStatement("INSERT INTO ticketflight VALUES (?,?)");
            pstmt.setInt(1, cancelFee);
            pstmt.setInt(2, flightScheduleID);
            pstmt.executeUpdate();
            pstmt.close();

            return true;

        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    // delete ticketflight
    public boolean deleteTicketFlight (int planeID) {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM ticketflight WHERE planeID = " + planeID);
            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    // update cancellation fee
    public boolean updateCancellationFee (int flightScheduleID, int newCancelFee) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE ticketflight SET cancelFee = "+ newCancelFee + " WHERE routeID = " + flightScheduleID);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }
}
