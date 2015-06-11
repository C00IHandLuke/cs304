/**
 * Created by Kelly on 2015-06-11.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Route {
    Connection conn = MySQLConnection.getInstance().getConnection();

    public Route() {}

    public boolean insertRoute(int routeID, String dest, String depart){
        try{
            PreparedStatement statement = conn.prepareStatement("INSERT INTO route VALUES (?, ?, ?)");
            statement.setInt(1, routeID);
            statement.setString(2, dest);
            statement.setString(3, depart);
            statement.executeUpdate();
            statement.close();
            return true;
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}

