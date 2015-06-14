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

    private int planeID;
    private String planeType;
    private int nSeats;

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

            this.planeID = planeID;
            this.planeType = planeType;
            this.nSeats = nSeats;

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

  /*  // getter methods
    public int getPlaneID () {
        return this.planeID;
    }

    public int getnSeats () {
        return this.nSeats;
    }

    public String getPlaneType () {
        return this.planeType;
    }*/
}