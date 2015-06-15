import java.sql.*;

public class Passenger {

    Connection con = MySQLConnection.getInstance().getConnection();

    public Passenger() {
    }

    public boolean addPassenger(int passengerId, String name, String address, String phone, Date DoB) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO passenger VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, passengerId);
            stmt.setString(2, name);
            stmt.setString(3, address);
            stmt.setString(4, phone);
            stmt.setDate(5, DoB);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean deletePassenger(String passengerId) {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM passenger WHERE branchId = " + passengerId);
            stmt.close();
            return (rows != 0) ? true : false;
        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }
}
