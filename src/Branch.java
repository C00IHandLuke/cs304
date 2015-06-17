import java.sql.*;

public class Branch {

    Connection con = MySQLConnection.getInstance().getConnection();

    public Branch () {}

    public boolean addBranch(int branchId, String phone) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO branch VALUES (?, ?)");
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

    public boolean deleteBranch(int branchId) {
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

    public boolean updatebranchPhone(String branchId, String newPhone){
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update Branch set phone ="+ newPhone + "WHERE branchId = " + branchId);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }

    }

}
