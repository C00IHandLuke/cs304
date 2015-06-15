
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Location {
    Connection con = MySQLConnection.getInstance().getConnection();

    public Location () {}

    public boolean insertLocation( String province, String city, String postalCode, String branchId  ){

        try {
            PreparedStatement stmt = con.prepareStatement("Insert into Location\n" +
                    "values (?,?,?,?)");
            stmt.setString(1, province);
            stmt.setString(2, city);
            stmt.setString(3, postalCode);
            stmt.setString(4, branchId);
            stmt.executeUpdate();
            stmt.close();
            return true;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean removeLocation (String province, String city, String postalcode){

        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("Delete from location\n" +
                    "where province =" + province +
                    "and city =" + city +
                    "and postalCode =" + postalcode);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }


}
