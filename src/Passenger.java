import java.sql.*;

public class Passenger {

    Connection con = MySQLConnection.getInstance().getConnection();

    public Passenger() {
    }

    public boolean addPassenger(int passengerId, String name, String address, String phone, Timestamp DoB) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO passenger VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, passengerId);
            stmt.setString(2, name);
            stmt.setString(3, address);
            stmt.setString(4, phone);
            stmt.setTimestamp(5, DoB);
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
            int rows = stmt.executeUpdate("DELETE FROM passenger WHERE passengerId = " + passengerId);
            stmt.close();
            return (rows != 0) ? true : false;
        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }


    public boolean changePassengerName(String newName, String passengerId) {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update passenger set name ="+ newName +"WHERE passengerId = " + passengerId);
            stmt.close();
            return (rows != 0) ? true : false;
        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean changePassengerAddress(String newAddress, String passengerId) {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update passenger set address ="+ newAddress +"WHERE passengerId = " + passengerId);
            stmt.close();
            return (rows != 0) ? true : false;
        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean changePassengerPhone(String newPhone, String passengerId) {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update passenger set phone ="+ newPhone +"WHERE passengerId = " + passengerId);
            stmt.close();
            return (rows != 0) ? true : false;
        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean changePassengerDoB(String newDoB, String passengerId) {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update passenger set DoB ="+ newDoB +"WHERE passengerId = " + passengerId);
            stmt.close();
            return (rows != 0) ? true : false;
        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }
}
