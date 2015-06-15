/*
 * Airplane.java
 *  Queries:
 *      - insert & delete airplane
 *      - update plane type & number of seats
 *      - search for airplane & return number of seats
 */

import java.sql.*;

public class Airplane {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    public Airplane () {}

    // add airplane
    public boolean insertAirplane (int planeID, String planeType, int nSeats) {
        try {
            pstmt = connect.prepareStatement("INSERT INTO airplane VALUES (?,?,?)");
            pstmt.setInt(1, planeID);
            pstmt.setString(2, planeType);
            pstmt.setInt(3, nSeats);
            pstmt.executeUpdate();
            pstmt.close();

            return true;

        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    // delete airplane
    public boolean deleteAirplane (int planeID) {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM airplane WHERE planeID = " + planeID);
            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    // update
    public boolean updateNumberOfSeats (int routeID, int newNumOfSeats) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE airplane SET nSeats = "+ newNumOfSeats + " WHERE routeID = " + routeID);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean updatePlaneType (int routeID, String newPlaneType) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE airplane SET planeType = "+ newPlaneType + " WHERE routeID = " + routeID);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    // get the number of seats associated with an airplane
    public int getNumberOfSeats (int planeID) {
        int nSeats = 0;
        try {
            resultSet = stmt.executeQuery("SELECT * FROM airplane WHERE planeID = " + planeID);
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