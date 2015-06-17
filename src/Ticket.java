/*
 * Ticket.java
 *  Queries:
 *      - insert & delete ticket
 *      - update ticket if cancelled
 */

import java.sql.*;
import java.util.Date;

public class Ticket {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;

    public Ticket(){}

    // add ticket
    public boolean insertTicket(int ticketNo, int price, String bkgDate, String cnlDate, String empID , int fsID, int passengerID) {
        try {
            pstmt = connect.prepareStatement("INSERT INTO ticket VALUES (?,?,?,?,?,?,?)");
            pstmt.setInt(1, ticketNo);
            pstmt.setInt(2, price);
            pstmt.setString(3, bkgDate);
            pstmt.setString(4, cnlDate);
            pstmt.setString(5, empID);
            pstmt.setInt(6, fsID);
            pstmt.setInt(7, passengerID);
            pstmt.executeUpdate();
            pstmt.close();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    // delete ticket
    public boolean deleteTicket(int ticketNo) {
        try{
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM ticket WHERE ticketNo = " + ticketNo);
            stmt.close();
            return (rows != 0) ? true : false;

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // cancels a ticket and update ticket table
    public boolean cancelTicket(int ticketNo) {
        Date currentDate = new java.util.Date();
        Timestamp currentTime = new Timestamp(currentDate.getTime());

        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE ticket SET cnlDate = "+ currentTime + " WHERE routeID = " + ticketNo);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    // searches for a ticket
    public void searchTicket() {

    }
}
