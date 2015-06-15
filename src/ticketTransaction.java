import java.sql.*;

public class ticketTransaction {

    Connection con = MySQLConnection.getInstance().getConnection();

    public ticketTransaction () {}

    public boolean addTicketTrans(int transactionId, int ticketNo) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO ticketTransaction VALUES (?, ?)");
            stmt.setInt(1, transactionId);
            stmt.setInt(2, ticketNo);
            stmt.executeUpdate();
            stmt.close();
            return true;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteTicketTrans(int transactionId, int ticketNo) {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM branch WHERE branchId = " + transactionId +"and ticketNo =" + ticketNo);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }


}
