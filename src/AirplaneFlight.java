/*
 * AirplaneFlight.java
 *  Specifications:
 *      - add/remove flight schedule to/from an airplane
 *
 *  Queries:
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AirplaneFlight {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    // add airplane-flight
    public boolean insertAirplaneFlight (int planeID, int fsID) {

        try {
            pstmt = connect.prepareStatement("INSERT INTO airplaneflight VALUES (?, ?)");
            pstmt.setInt(1, planeID);
            pstmt.setInt(2, fsID);
            pstmt.executeUpdate();
            pstmt.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    // delete airplane-flight
    public boolean deleteAirplaneFlight (int planeID, int fsID) {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate(
                    "DELETE from airplaneflight " +
                            "WHERE planeID = " + planeID +
                            "AND fsID = " + fsID);

            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
