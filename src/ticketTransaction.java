import java.sql.*;

public class ticketTransaction {

    Connection con = MySQLConnection.getInstance().getConnection();

    public ticketTransaction () {}

    public boolean addTicketTrans(int branchId, String phone) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO customer VALUES (?, ?)");
            stmt.setInt(1, branchId);
            stmt.setString(2, phone);
            stmt.executeUpdate();
            stmt.close();
            return true;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteTicketTrans(int branchId) {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM branch WHERE branchId = " + branchId);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }


}