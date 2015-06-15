/*
 * FlightSchedule.java
 *  Queries:
 *      - insert & delete airplane into flightschedule
 *      - insert & delete route into flightschedule
 *      - update airplane, route, depart-time & arrive-time in flightschedule
 *      - search for flightschedule
 */

import java.sql.*;

public class FlightSchedule {
    private Connection connect = MySQLConnection.getInstance().getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    public FlightSchedule() {}

    // add airplane into flightschedule
    public boolean insertAirplaneIntoFlightSchedule (int fsID, Timestamp departTime, Timestamp arriveTime, int seatsAvail, int planeID, int routeID) {
        try {
            pstmt = connect.prepareStatement("INSERT INTO flightschedule VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, fsID);
            pstmt.setTimestamp(2, departTime);
            pstmt.setTimestamp(3, arriveTime);
            pstmt.setInt(4, seatsAvail);
            pstmt.setInt(5, planeID);
            pstmt.setInt(6, routeID);
            pstmt.executeUpdate();
            pstmt.close();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // delete airplane from flightschedule
    public boolean deleteAirplaneFromFlightSchedule (int fsID, int planeID, Timestamp departTime, Timestamp arriveTime) {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate(
                    "DELETE from flightschedule" +
                            " WHERE fsID = " + fsID +
                            " AND planeID = " + planeID +
                            " AND departTime = " + departTime +
                            " AND arriveTime = " + arriveTime);
            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // insert route into flightschedule
    public boolean insertRouteIntoFlightSchedule (int fsID, Timestamp depTime, Timestamp avlTime, int seatsAvail, int planeID, int routeID) {
        try {
            pstmt.setInt(1, fsID);
            pstmt.setTimestamp(2, depTime);
            pstmt.setTimestamp(3, avlTime);
            pstmt.setInt(4, seatsAvail);
            pstmt.setInt(5, planeID);
            pstmt.setInt(6, routeID);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // delete route from flightschedule
    public boolean deleteRouteFromFlightSchedule (int fsID, int routeID, Timestamp depTime, Timestamp avlTime) {
        try {
            stmt = connect.createStatement();
            int rows = stmt.executeUpdate(
                    "DELETE from flightschedule" +
                            " WHERE fsID = " + fsID +
                            " AND routeID = " + routeID +
                            " AND departTime = " + depTime +
                            " AND arriveTime = " + avlTime);
            stmt.close();
            return (rows != 0) ? true : false;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // updates
    public boolean updateRouteInFlightSchedule (int fsID, int newRouteID) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE flightschedule SET routeID = "+ newRouteID + " WHERE fsID = " + fsID);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateAirplaneInFlightSchedule (int fsID, int newPlaneID) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate("UPDATE flightschedule SET planeID = "+ newPlaneID + " WHERE fsID = " + fsID);
            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateTimeInFlightSchedule (int fsID, Timestamp newDepartTime, Timestamp newArriveTime) {
        try {
            Statement stmt = connect.createStatement();
            int rows = stmt.executeUpdate(
                    "UPDATE flightschedule " +
                    "SET departTime = " + newDepartTime + ", arriveTime = " + newArriveTime +
                            " WHERE fsID = " + fsID);

            stmt.close();
            return (rows != 0) ? true: false;
        }
        catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            return false;
        }
    }

    // searches for available flights
    public int searchFlightSchedule (Timestamp ts) {
        Timestamp time = null;
        int fsID = 0;
        try {
            resultSet = stmt.executeQuery("SELECT * FROM flightschedule WHERE departTime = " + ts);
            while (resultSet.next()){
                fsID = resultSet.getInt(1);
                time = resultSet.getTimestamp(2);
            }
            if (time == null)
                return 0;
            else
                return fsID;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int searchFlightSchedule (int routeID) {
        int fsID = 0;
        try {
            resultSet = stmt.executeQuery("SELECT * FROM flightschedule WHERE routeID = " + routeID);
            while (resultSet.next()){
                fsID = resultSet.getInt(1);
            }
            if (fsID == 0)
                return 0;
            else
                return fsID;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getSeatsAvailable (int fsID) {
        int n = 0;
        try {
            resultSet = stmt.executeQuery("SELECT nSeats WHERE fsID = " + fsID);
            while (resultSet.next()){
                n = resultSet.getInt(4);
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
