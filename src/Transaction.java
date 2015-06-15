import java.sql.*;

public class Transaction {

    Connection con = MySQLConnection.getInstance().getConnection();

    public Transaction () {}

    public boolean insertTransaction(String transactionId, String paymentMethod, String employeeId, String passengerId) {
        try {
            PreparedStatement stmt = con.prepareStatement("insert into Transactions\n" +
                    "values (?,?,?,?)");
            stmt.setString(1, transactionId);
            stmt.setString(2, paymentMethod);
            stmt.setString(3, employeeId);
            stmt.setString(4, passengerId);
            stmt.executeUpdate();
            stmt.close();
            return true;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteTransaction(String transactionId) {
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
