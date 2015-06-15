import java.sql.*;

public class Employee {


    Connection con = MySQLConnection.getInstance().getConnection();

    public Employee () {}

    public boolean addEmployee(String employeeId,String name,String address,String role,String phone,String branchId) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, employeeId);
            stmt.setString(2, name);
            stmt.setString(3, address);
            stmt.setString(4, role);
            stmt.setString(5, phone);
            stmt.setString(6, branchId);
            stmt.executeUpdate();
            stmt.close();
            return true;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean removeEmployee(String employeeId) {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM employee WHERE employeeId = " + employeeId);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateEmployeeName(String employeeId, String newName){
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update Employee set name ="+ newName + "WHERE employeeId = " + employeeId);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateEmployeeAddress(String employeeId, String newAddress){
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update Employee set address ="+ newAddress + "WHERE employeeId = " + employeeId);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateEmployeeRole(String employeeId, String newRole){
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update Employee set role ="+ newRole + "WHERE employeeId = " + employeeId);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateEmployeePhone(String employeeId, String newPhone){
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update Employee set phone ="+ newPhone + "WHERE employeeId = " + employeeId);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateEmployeeBranchId(String employeeId, String newBranchId){
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Update Employee set branchId ="+ newBranchId + "WHERE employeeId = " + employeeId);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }
}
