/*
 * Ticket.java
 *  Specifications:
 *      issue a ticket
 *      cancel a ticket
 *
 *  Queries:
 *      search for ticket
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ticket {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    public String bkgDate;

    public Ticket(){}

    // add ticket
    public boolean insertTicket(int ticketNo, int price, String bkgDate, String cnlDate, int empID , int fsID, int passengerID) {
        try {
            pstmt = connect.prepareStatement("INSERT into route VALUES (?,?,?,?,?,?,?)");
            pstmt.setInt(1, ticketNo);
            pstmt.setInt(2, price);
            pstmt.setString(3, bkgDate);
            pstmt.setString(4, cnlDate);
            pstmt.setInt(5, empID);
            pstmt.setInt(6, fsID);
            pstmt.setInt(7, passengerID);
            pstmt.executeUpdate();
            pstmt.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    // delete ticket
    public boolean deleteTicket(int ticketNo) {

        try{
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate("DELETE from ticket WHERE ticketNo = " + ticketNo);
            stmt.close();
            return (rows != 0) ? true : false;

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // cancels a ticket and calculate its cancellation fee
    public void cancelTicket(int ticketNo) {

        try {

            resultSet = stmt.executeQuery("select * from ticket where ticketNo = " + ticketNo);

            while (resultSet.next()) {
                String bkgDate = resultSet.getString(3);
                System.out.println(bkgDate);
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // searches for a ticket
    public void searchTicket() {

    }


}
