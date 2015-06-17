import java.sql.*;

public class Transaction {

    Connection con = MySQLConnection.getInstance().getConnection();

    public Transaction () {}

    public boolean insertTransaction(int transactionId, String paymentMethod, String employeeId, int passengerId) {
        try {
            PreparedStatement stmt = con.prepareStatement("insert into Transactions\n" +
                    "values (?,?,?,?)");
            stmt.setInt(1, transactionId);
            stmt.setString(2, paymentMethod);
            stmt.setString(3, employeeId);
            stmt.setInt(4, passengerId);
            stmt.executeUpdate();
            stmt.close();
            return true;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteTransaction(int transactionId) {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM transaction WHERE transcationId = " + transactionId);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

}
