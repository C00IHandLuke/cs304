/*
 * Airplane.java
 *  Queries:
 *      - insert airplane
 *      - delete airplane
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Airplane {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    public Airplane () {}

    // add airplane
    public boolean insertAirplane (int planeID, String planeType, int nSeats) {
        try {
            pstmt = connect.prepareStatement("INSERT into airplane VALUES (?,?,?)");
            pstmt.setInt(1, planeID);
            pstmt.setString(2, planeType);
            pstmt.setInt(3, nSeats);
            pstmt.executeUpdate();
            pstmt.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // delete airplane
    public boolean deleteAirplane (int planeID) {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate("DELETE from airplane WHERE planeID = " + planeID);
            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // find the number of seats associated with an airplane
    public int getnSeats (int planeID) {
        int nSeats = 0;
        try {
            resultSet = stmt.executeQuery("SELECT airplane.nSeats from airplane WHERE planeID = " + planeID);
            while(resultSet.next()){
                nSeats = resultSet.getInt(3);
            }
            return nSeats;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}